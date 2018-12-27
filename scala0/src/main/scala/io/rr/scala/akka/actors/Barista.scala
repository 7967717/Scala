package io.rr.scala.akka.actors

import akka.actor._
import Register._
import EspressoCup._
import akka.actor.SupervisorStrategy.{Decider, Directive, Restart, Resume, Stop}
import akka.util.Timeout
import akka.pattern.{AskTimeoutException, ask}
import io.rr.scala.akka.actors.ReceiptPrinter.PrintJob

import concurrent.duration._
import scala.util.Random


object Barista extends App {
  val system = ActorSystem("BaristaActorSystem")
  val barista = system.actorOf(Props[Barista], "Barista")
  val customerJohnny = system.actorOf(Props(classOf[Customer], barista), "Johnny")
  val customerAlina = system.actorOf(Props(classOf[Customer], barista), "Alina")

  final val defaultStrategy: SupervisorStrategy = {
    def defaultDecider: Decider = {
      case _: ActorInitializationException ⇒ Stop
      case _: ActorKilledException         ⇒ Stop
      case _: Exception                    ⇒ Restart
    }
    OneForOneStrategy()(defaultDecider)
  }

  customerJohnny ! CaffeineWithdrawalWarning
  customerAlina ! CaffeineWithdrawalWarning
  Thread.sleep(2000)
  customerAlina ! CaffeineWithdrawalWarning
  Thread.sleep(2000)
  customerAlina ! CaffeineWithdrawalWarning
  Thread.sleep(2000)
  customerJohnny ! CaffeineWithdrawalWarning

  Thread.sleep(5000)
  barista ! ClosingTime

}

sealed trait CoffeeRequest
case object CappuccinoRequest extends CoffeeRequest
case object EspressoRequest extends CoffeeRequest
case class Bill(cents: Int)
case object ClosingTime

case class EspressoCup(state: EspressoCup.State)
object EspressoCup {
  sealed trait State
  case object Clean extends State
  case object Filled extends State
  case object Dirty extends State
}
case class Receipt(amount: Int)

class Barista extends Actor {
  import context.dispatcher
  import akka.pattern.pipe

  implicit val timeout: Timeout = Timeout(4.seconds)
  val register: ActorRef = context.actorOf(Props[Register], "Register")
  def receive: PartialFunction[Any, Unit] = {
    case EspressoRequest =>
      val receipt = register ? Transaction(Espresso)
      receipt.map((EspressoCup(Filled), _)).recover {
        case _: AskTimeoutException => ComebackLater
      } pipeTo(sender)
    case ClosingTime => context.stop(self)
  }

//  val decider: PartialFunction[Throwable, Directive] = {
//    case _: PaperJamException => Resume
//  }
//  override def supervisorStrategy: SupervisorStrategy =
//    OneForOneStrategy()(decider.orElse(SupervisorStrategy.defaultStrategy.decider))
}

case object CaffeineWithdrawalWarning
case object ComebackLater
class Customer(coffeeSource: ActorRef) extends Actor with ActorLogging {
  import context.dispatcher
  context.watch(coffeeSource)

  def receive = {
    case CaffeineWithdrawalWarning => coffeeSource ! EspressoRequest
    case (EspressoCup(Filled), Receipt(amount)) =>
      log.info(s"yay, caffeine for $self!")
    case ComebackLater =>
      log.info("grumble, grumble")
      context.system.scheduler.scheduleOnce(300.millis) {
        coffeeSource ! EspressoRequest
      }
    case Terminated(barista) =>
      log.info("Oh well, let's find another coffeehouse...")
      context.system.terminate()
  }
}

object Register {
  sealed trait Article
  case object Espresso extends Article
  case object Cappuccino extends Article
  case class Transaction(article: Article)
  class PaperJamException(msg: String) extends Exception(msg)
}

class Register extends Actor with ActorLogging {
  import akka.pattern.ask
  import akka.pattern.pipe
  import context.dispatcher
  implicit val timeout: Timeout = Timeout(4.seconds)
  private var revenue = 0
  private val prices = Map[Article, Int](Espresso -> 150, Cappuccino -> 250)
  private val printer = context.actorOf(Props[ReceiptPrinter], "Printer")
  override def postRestart(reason: Throwable) {
    super.postRestart(reason)
    log.info(s"Restarted, and revenue is $revenue cents")
  }
  def receive: PartialFunction[Any, Unit] = {
    case Transaction(article) =>
      val price = prices(article)
      val requester = sender
      (printer ? PrintJob(price)).map((requester, _)).pipeTo(self)
    case (requester: ActorRef, receipt: Receipt) =>
      revenue += receipt.amount
      log.info(s"revenue is $revenue cents")
      requester ! receipt
  }
}

object ReceiptPrinter {
  case class PrintJob(amount: Int)
  class PaperJamException(msg: String) extends Exception(msg)
}
class ReceiptPrinter extends Actor with ActorLogging {
  private var paperJam = false
  override def postRestart(reason: Throwable) {
    super.postRestart(reason)
    log.info(s"Restarted, paper jam == $paperJam")
  }
  def receive: PartialFunction[Any, Unit] = {
    case PrintJob(amount) => sender ! createReceipt(amount)
  }
  private def createReceipt(price: Int): Receipt = {
    if (Random.nextBoolean()) paperJam = true
    if (paperJam) throw new PaperJamException("OMG, not again!")
    log.info(s"printing receipt for $price cents")
    Receipt(price)
  }
}


