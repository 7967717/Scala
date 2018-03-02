package io.rr.scala.akka.future

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success, Try}
import scala.concurrent.duration._

object Future001 extends App {
  implicit val ec = ExecutionContext.global
//  onComplete the most important method in Future
  val start = Future {Thread.sleep(1000); "Start"}
  Future {Thread.sleep(3000); "3 seconds from the start"}.onComplete(printContent)
  Future {Thread.sleep(5000); "5 seconds from the start"}.onComplete(printContent)
  Future {Thread.sleep(7000); "7 seconds from the start"}.onComplete(printContent)

//  blocking operation
  println("Waiting one second to start")
  private val duration = 1 seconds
  private val str: String = Await.result(start, duration)
  println(str)

  def printContent[T](fut: Try[T]) = fut match {
      case Success(res) => println(res)
      case Failure(ex) => println(ex)
  }

  for (i <- 1 to 10) {
    println("i " + i)
    Thread.sleep(1000)
  }

  println("Finished")
}
