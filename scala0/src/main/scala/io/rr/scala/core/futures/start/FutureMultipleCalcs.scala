package io.rr.scala.akka.future

import java.util.concurrent.TimeUnit

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

object FutureMultipleCalcs extends App {
  println("starting futures")
  val result1 = Cloud.runAlgorithm(10)
  val result2 = Cloud.runAlgorithm(20)
  val result3 = Cloud.runAlgorithm(30)
  println("before for-comprehension")
  val result = for {
    r1 <- result1
    r2 <- result2
    r3 <- result3
  } yield r1 + r2 + r3
  println("before onSuccess")
//  result.onComplete {
//    case result => println(s"total = $result")
//  }
  result.foreach {
    result => println(s"total = $result")
  }
  println("before sleep at the end")
  TimeUnit.MILLISECONDS.sleep(2000) // keep the jvm alive
}

object Cloud {
  def runAlgorithm(i: Int): Future[Int] = Future {
    TimeUnit.MILLISECONDS.sleep(Random.nextInt(500))
    val result = i + 10
    println(s"returning result from cloud: $result")
    result
  }
}