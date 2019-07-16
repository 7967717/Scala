package io.rr.scala.kafka

import java.util.{Properties}
import org.apache.kafka.clients.consumer.KafkaConsumer

object KafkaClient {
  def main(args: Array[String]): Unit = {

    val props = new Properties()
    props.put("bootstrap.servers", "10.150.34.18:9092")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("request.timeout.ms", "5000")
    props.put("session.timeout.ms", "4000")

    val consumer = new KafkaConsumer[String, String](props)
    println("---------")
    try{
      val topics = consumer.listTopics().keySet()
      println(topics)
    } catch {
      case e: Exception => println(s"Exception $e.getMessage")
      case e: Throwable => println(s"Throwable $e.getMessage")
    }
    println("---------")

  }

}
