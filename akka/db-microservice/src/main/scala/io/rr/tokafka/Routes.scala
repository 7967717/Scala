package io.rr.tokafka

import akka.actor.{ActorRef, ActorSystem}
import akka.event.Logging

import scala.concurrent.duration._
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.MethodDirectives.{delete, get, post}
import akka.http.scaladsl.server.directives.RouteDirectives.complete
import akka.http.scaladsl.server.directives.PathDirectives.path

import akka.util.Timeout
import io.rr.tokafka.MessagesActor._
import akka.pattern.ask
import scala.concurrent.Future


trait Routes extends JsonSupport {
  // we leave these abstract, since they will be provided by the App
  implicit def system: ActorSystem

  lazy val log = Logging(system, classOf[Routes])

  // other dependencies that Routes use
  def messagesActor: ActorRef

  // Required by the `ask` (?) method below
  implicit lazy val timeout = Timeout(5.seconds) // usually we'd obtain the timeout from the system's configuration

  lazy val messageRoutes: Route =
    pathPrefix("message") {
      concat(
        pathEnd {
          concat(
            get {
              val messages: Future[Messages] =
                (messagesActor ? GetMessages).mapTo[Messages]
              complete(messages)
            },
            post {
              entity(as[Message]) { message =>
                val messageForwarded: Future[ActionPerformed] =
                  (messagesActor ? MessageToKafka(message)).mapTo[ActionPerformed]
                onSuccess(messageForwarded) { forwarded =>
                  log.info("Message forwarded [{}]: {}", message.message, forwarded.description)
                  complete((StatusCodes.Accepted, forwarded))
                }
              }
            }
          )
        }
      )
    }

}
