package io.rr.tokafka

import akka.actor.ActorSystem
import akka.kafka.ProducerMessage
import akka.kafka.ProducerSettings
import akka.kafka.scaladsl.Producer
import akka.stream.scaladsl.Source
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.ByteArraySerializer
import org.apache.kafka.common.serialization.StringSerializer
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Sink

import scala.concurrent.Future
import akka.Done

import scala.util.{Failure, Success}

trait ProducerToKafka {
  val system = ActorSystem("db-microservice")

  // #producer
  // #settings
  val producerSettings = ProducerSettings(system, new ByteArraySerializer, new StringSerializer)
    .withBootstrapServers("localhost:9092")
  // #settings
  val kafkaProducer = producerSettings.createKafkaProducer()
  // #producer

  implicit val ec = system.dispatcher
  implicit val materializer = ActorMaterializer.create(system)

  def terminateWhenDone(result: Future[Done]): Unit = {
    result.onComplete {
      case Failure(e) =>
        system.log.error(e, e.getMessage)
        system.terminate()
      case Success(_) => system.terminate()
    }
  }

}

object PlainProducerExample extends ProducerToKafka {
  def main(args: Array[String]): Unit = {
    // #plainSink
    val done = Source(1 to 10)
      .map(_.toString)
      .map(x => s"Message #$x")
      .map { elem =>
        new ProducerRecord[Array[Byte], String]("test", elem)
      }
      .runWith(Producer.plainSink(producerSettings))
    // #plainSink

    terminateWhenDone(done)
  }
}

object ProducerOne extends ProducerToKafka {
  def main(args: Array[String]): Unit = {
    forward("test", "message 1")
  }

  def forward(topic: String, message: String) = {
    val record = new ProducerRecord[Array[Byte], String](topic, message)
    kafkaProducer.send(record)
    kafkaProducer.close()
  }
}

