package io.rr.scala.akka.actors

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.{ActorRef, Props}


object Barista extends App {
  val system = ActorSystem("Barista")
  val barista = system.actorOf(Props[Barista], "Barista")
  val customer = system.actorOf(Props(classOf[Customer], barista), "Customer")
  customer ! CaffeineWithdrawalWarning
  barista ! ClosingTime
//  barista ! CappuccinoRequest
//  barista ! EspressoRequest
//  println("I ordered a cappuccino and an espresso")
  system.terminate()
}

sealed trait CoffeeRequest
case object CappuccinoRequest extends CoffeeRequest
case object EspressoRequest extends CoffeeRequest
case class Bill(cents: Int)
case object ClosingTime

class Barista extends Actor {
  var cappuccinoCount = 0
  var espressoCount = 0
  def receive = {
    case CappuccinoRequest =>
      sender ! Bill(250)
      cappuccinoCount += 1
      println(s"I have to prepare cappuccino #$cappuccinoCount")
    case EspressoRequest =>
      sender ! Bill(200)
      espressoCount += 1
      println(s"Let's prepare espresso #$espressoCount.")
    case ClosingTime => context.system.terminate()
  }
}

case object CaffeineWithdrawalWarning
class Customer(caffeineSource: ActorRef) extends Actor {
  def receive = {
    case CaffeineWithdrawalWarning => caffeineSource ! EspressoRequest
    case Bill(cents) => println(s"I have to pay $cents cents, or else!")
  }
}


