package io.rr.scala.akka.actors

import akka.actor.{Actor, ActorSystem, Props}
import io.rr.scala.akka.actors.ActorHierarchyExperiments.system

import scala.io.StdIn

/**
  * @author rrudenko on 02.10.2017.
  */
class StartStopActor1 extends Actor {
  override def preStart(): Unit = {
    println("first started")
    context.actorOf(Props[StartStopActor2], "second")
  }
  override def postStop(): Unit = println("first stopped")

  override def receive: Receive = {
    case "stop" => context.stop(self)
  }
}

class StartStopActor2 extends Actor {
  override def preStart(): Unit = println("second started")
  override def postStop(): Unit = println("second stopped")

  // Actor.emptyBehavior is a useful placeholder when we don't
  // want to handle any messages in the actor.
  override def receive: Receive = Actor.emptyBehavior
}

object ActorStopExperiments extends App {
  val system = ActorSystem("testSystem")

  val first = system.actorOf(Props[StartStopActor1], "first")
  first ! "stop"

  println(">>> Press ENTER to exit <<<")
  try StdIn.readLine()
  finally system.terminate()

}
