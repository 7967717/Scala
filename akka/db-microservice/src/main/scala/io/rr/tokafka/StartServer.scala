package io.rr.tokafka

import akka.actor.{ActorRef, ActorSystem}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object StartServer extends App with Routes{

  // set up ActorSystem and other dependencies here
  implicit val system: ActorSystem = ActorSystem("toKafkaServer")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val messagesActor: ActorRef = system.actorOf(MessagesActor.props, "messagesActor")

  // from the Routes trait
  lazy val routes: Route = messageRoutes

  Http().bindAndHandle(routes, "localhost", 8087)

  println(s"Server online at http://localhost:8087/")

  Await.result(system.whenTerminated, Duration.Inf)

}
