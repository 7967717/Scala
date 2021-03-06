package io.rr.tokafka

import akka.actor.{Actor, ActorLogging, Props}
import org.apache.kafka.clients.producer.ProducerRecord

final case class Message(message: String)
final case class Messages(messages: Seq[Message])

object MessagesActor {
  final case class ActionPerformed(description: String)
  final case object GetMessages
  final case class MessageToKafka(message: Message)

  def props: Props = Props[MessagesActor]
}

class MessagesActor extends Actor with ActorLogging {
  import MessagesActor._

  var messages = Set.empty[Message]
  val sink = new SinkToKafka

  override def receive: Receive = {
    case GetMessages =>
      sender() ! Messages(messages.toSeq)
    case MessageToKafka(message) =>
      messages += message
      sink.forward("test", message.message)
      sender() ! ActionPerformed(s"Message '${message.message}' was forwarded to Kafka.\n")
  }
}

class SinkToKafka extends ProducerToKafka {
  def forward(topic: String, message: String) = {
    val record = new ProducerRecord[Array[Byte], String](topic, message)
    kafkaProducer.send(record)
  }
}