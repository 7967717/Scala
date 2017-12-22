package io.rr.scala.akka.actors

import akka.actor._


object MyPoisonPill extends App {
  val system = ActorSystem("PoisonPillTest")
  val actor = system.actorOf(Props[MyActor], name = "test")
  // a simple message
  actor ! "before PoisonPill"
  // the PoisonPill
  actor ! PoisonPill
  // these messages will not be processed
  actor ! "after PoisonPill"
  actor ! "hello?!"
  system.terminate
}

class MyActor extends Actor {
  def receive = {
    case s:String => println("Message Received: " + s)
    case _ => println("MyActor got an unknown message")
  }
  override def postStop { println("MyActor::postStop called") }
}
