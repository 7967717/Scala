package io.rr.scala.akka.future

import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random
import scala.util.{Failure, Success}
import scala.concurrent.Future

object Future03 extends App {
  println("starting calculation ...")
  val f = Future {
    TimeUnit.MILLISECONDS.sleep(Random.nextInt(500))
    42
  }
  println("before onComplete")
  f.onComplete {
    case Success(value) => println(s"Got the callback, meaning = $value")
    case Failure(e) => e.printStackTrace
  }
  // do the rest of your work
  println("A ..."); TimeUnit.MILLISECONDS.sleep(100)
  println("B ..."); TimeUnit.MILLISECONDS.sleep(100)
  println("C ..."); TimeUnit.MILLISECONDS.sleep(100)
  println("D ..."); TimeUnit.MILLISECONDS.sleep(100)
  println("E ..."); TimeUnit.MILLISECONDS.sleep(100)
  println("F ..."); TimeUnit.MILLISECONDS.sleep(100)
  TimeUnit.MILLISECONDS.sleep(2000)
}
