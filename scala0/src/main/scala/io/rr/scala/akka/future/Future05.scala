package io.rr.scala.akka.future

import java.util.concurrent.TimeUnit

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future}
import scala.util.{Failure, Success}

object Future05 extends App {
  implicit val baseTime = System.currentTimeMillis

  def longRunningComputation(i: Int): Future[Int] = Future {
    TimeUnit.MILLISECONDS.sleep(100)
    i + 1
  }

  // this does not block
  longRunningComputation(11).onComplete {
    case Success(result) => println(s"result = $result")
    case Failure(e) => e.printStackTrace
  }
  TimeUnit.MILLISECONDS.sleep(1000)
}
