package io.rr.scala.core.futures.start

import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Success

/**
  * @author rrudenko on 12.10.2017.
  */
object Future01 {
  def main(args: Array[String]): Unit = {
    val oneF = Future{
      TimeUnit.SECONDS.sleep(1)
      println("Hello from future " + Thread.currentThread().getName)
      1
    }
    println(oneF.isCompleted)
    TimeUnit.SECONDS.sleep(1)
    println(oneF.isCompleted)
    oneF.onComplete{
      println("---------------------")
      print("onComplete ")
      println
    }

    oneF.andThen{
      case Success(n) => println("n - " + n)
    }.map(_ * 10).foreach(println)

    TimeUnit.SECONDS.sleep(2)
  }

}
