package io.rr.tokafka

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import io.rr.tokafka.MessagesActor.ActionPerformed
import spray.json.DefaultJsonProtocol

trait JsonSupport extends SprayJsonSupport {
  // import the default encoders for primitive types (Int, String, Lists etc)
  import DefaultJsonProtocol._

  implicit val messageJsonFormat = jsonFormat1(Message)
  implicit val messagesJsonFormat = jsonFormat1(Messages)
  implicit val actionPerformedJsonFormat = jsonFormat1(ActionPerformed)

}
