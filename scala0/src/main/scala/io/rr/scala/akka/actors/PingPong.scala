package io.rr.scala.akka.actors

import akka.actor._

object PingPong extends App {
  val system = ActorSystem("PingPong")
  val pong = system.actorOf(Props[Pong], name = "pong")
  val ping = system.actorOf(Props(new Ping(pong)), name = "ping")
  ping ! StartMessage

  Thread.sleep(2000)
  system.terminate()
}

case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage

class Ping(pong: ActorRef) extends Actor {
  var count = 0
  def incrementAndPrint: Unit = { count += 1; println("ping")}

  override def receive = {
    case StartMessage =>
      incrementAndPrint
      pong ! PingMessage
    case PongMessage =>
      incrementAndPrint
      if (count > 99) {
        sender ! StopMessage
        println("ping stopped")
        context.stop(self)
      } else {
        pong ! PingMessage
      }
    case _ => println("Unexpected message at Ping")
  }
}

class Pong() extends Actor {
  override def receive = {
    case PingMessage =>
      println("pong")
      sender ! PongMessage
    case StopMessage =>
      println("pong stopped")
      context.stop(self)
    case _ => println("Unexpected message at Pong")
  }
}


