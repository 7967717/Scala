package io.rr.scala.akka.actors

import akka.actor._

object ActorLifecycle extends App {
  val system = ActorSystem("LifecycleDemo")
  val myActor = system.actorOf(Props[MyActor], name = "MyActor")
  println("sending MyActor a simple String message")
  myActor ! "hello"
  Thread.sleep(1000)
  println("make MyActor restart")
  myActor ! ForceRestart
  Thread.sleep(1000)
  println("stopping MyActor")
  system.stop(myActor)
  println("shutting down system")
  system.terminate()
}

class MyActor extends Actor {
  println("entered the MyActor constructor")

  override def preStart(): Unit = {
    println("MyActor preStart")
  }

  override def postStop(): Unit = {
    println("MyActor postStop")
  }

  override def preRestart(reason: Throwable, message: Option[Any]) {
    println("MyActor: preRestart")
    println(s" MESSAGE: ${message.getOrElse("")}")
    println(s" REASON: ${reason.getMessage}")
    super.preRestart(reason, message)
  }

  override def postRestart(reason: Throwable) {
    println("MyActor: postRestart")
    println(s" REASON: ${reason.getMessage}")
    super.postRestart(reason)
  }

  override def receive = {
    case ForceRestart => throw new Exception("Boom!")
    case _ => println("MyActor received a message")
  }
}

case object ForceRestart
