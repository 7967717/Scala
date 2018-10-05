package com.lightbend.akka.sample

import akka.actor.{Actor, Props, ActorSystem}
import scala.io.StdIn

//#1
class PrintMyActorRefActor extends Actor {
  override def receive: Receive = {
    case "printit" ⇒
      val secondRef = context.actorOf(Props.empty, "second-actor")
      println(s"Second: $secondRef")
  }
}

//#2
class StartStopActor1 extends Actor {
  override def preStart(): Unit = {
    println("first started")
    context.actorOf(Props[StartStopActor2], "second")
  }

  override def postStop(): Unit = println("first stopped")

  override def receive: Receive = {
    case "stop" ⇒ context.stop(self)
  }
}

class StartStopActor2 extends Actor {
  override def preStart(): Unit = println("second started")
  override def postStop(): Unit = println("second stopped")

  // Actor.emptyBehavior is a useful placeholder when we don't
  // want to handle any messages in the actor.
  override def receive: Receive = Actor.emptyBehavior
}

//#3
class SupervisingActor extends Actor {
  val child = context.actorOf(Props[SupervisedActor], "supervised-actor")

  override def receive: Receive = {
    case "failChild" ⇒ child ! "fail"
    case "printit" ⇒ child ! "printit"
  }
}

class SupervisedActor extends Actor {
  override def preStart(): Unit = println("supervised actor started")
  override def postStop(): Unit = println("supervised actor stopped")

  override def preRestart(reason: Throwable, message: Option[Any]):  Unit = println(message, reason)



  override def receive: Receive = {
    case "fail" ⇒
      println("supervised actor fails now")
      throw new Exception("I failed!")
    case "printit" ⇒
      println("Restarted")
  }
}


object ActorHierarchyExperiments extends App {
  val system = ActorSystem("testSystem")

  //  #1
  //  val firstRef = system.actorOf(Props[PrintMyActorRefActor], "first-actor")
  //  println(s"First: $firstRef")
  //  firstRef ! "printit"

  //  #2
  //  val first = system.actorOf(Props[StartStopActor1], "first")
  //  first ! "stop"

  //  #3
  val supervisingActor = system.actorOf(Props[SupervisingActor], "supervising-actor")
  supervisingActor ! "failChild"
  supervisingActor ! "printit"


//  println(">>> Press ENTER to exit <<<")
//  try StdIn.readLine()
//  finally system.terminate()

}
