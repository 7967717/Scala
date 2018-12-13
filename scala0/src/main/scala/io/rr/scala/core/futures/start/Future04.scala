package io.rr.scala.core.futures.start

import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Random

object Future04 extends App{
  val f = Future {
    TimeUnit.MILLISECONDS.sleep(Random.nextInt(500))
    if (Random.nextInt(500) > 250) throw new Exception("Yikes!") else 42
  }
  f.onSuccess {
      case result => println(s"Success: $result")
    }
  f.onFailure {
      case t => println(s"Exception: ${t.getMessage}")
    }
  // do the rest of your work
  println("A ..."); TimeUnit.MILLISECONDS.sleep(100)
  println("B ..."); TimeUnit.MILLISECONDS.sleep(100)
  println("C ..."); TimeUnit.MILLISECONDS.sleep(100)
  println("D ..."); TimeUnit.MILLISECONDS.sleep(100)
  println("E ..."); TimeUnit.MILLISECONDS.sleep(100)
  println("F ..."); TimeUnit.MILLISECONDS.sleep(100)
}
