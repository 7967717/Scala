package io.rr.scala.akka.future

import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * @author rrudenko on 08.11.2017.
  */
object Future02 {
  def main(args: Array[String]): Unit = {
    val fut = Future { TimeUnit.SECONDS.sleep(1); 21 + 21 }
    println(fut.value)
    fut.foreach(x => println("foreach " + x))
    fut.onComplete {
      case Success(res) => println("onComplete " + res)
      case Failure(ex) => println(ex)
    }
    TimeUnit.SECONDS.sleep(2)
  }
}
