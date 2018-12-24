package io.rr.scala.akka.actors

import akka.actor._

object BecomeActor extends App {
  val system = ActorSystem("BecomeHulkExample")
  val actorstates = system.actorOf(Props[ActorStates], name = "ActorStates")
  actorstates ! ActNormalMessage // init to normalState
  actorstates ! TryToFindSolution
  actorstates ! BadGuysMakeMeAngry
  Thread.sleep(1000)
  actorstates ! ActNormalMessage
  system.terminate
}

class ActorStates extends Actor {
  import context._
  def angryState: Receive = {
    case ActNormalMessage =>
      println("Phew, I'm back to normal state.")
      become(normalState)
  }
  def normalState: Receive = {
    case TryToFindSolution =>
      println("Looking for solution to my problem ...")
    case BadGuysMakeMeAngry =>
      println("I'm getting angry...")
      become(angryState)
  }
  def receive = {
    case BadGuysMakeMeAngry => become(angryState)
    case ActNormalMessage => become(normalState)
  }
}

case object ActNormalMessage
case object TryToFindSolution
case object BadGuysMakeMeAngry

