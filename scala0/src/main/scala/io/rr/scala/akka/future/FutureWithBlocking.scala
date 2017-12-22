package io.rr.scala.akka.future

import java.util.concurrent.TimeUnit
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureWithBlocking extends App {
  // used by 'time' method
  implicit val baseTime = System.currentTimeMillis
  // 2 - create a Future
  val f = Future {
    TimeUnit.MILLISECONDS.sleep(500)
//    TimeUnit.MILLISECONDS.sleep(1500) //throws java.util.concurrent.TimeoutException
    1 + 1
  }
  // 3 - this is blocking (blocking is bad)
  val result = Await.result(f, 1 second)
  println(result)
  TimeUnit.MILLISECONDS.sleep(1000)
}
