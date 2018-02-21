package io.rr.scala.akka.future

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.blocking

object Future06 extends App {
  implicit val ec = ExecutionContext.global

  for( i <- 1 to 32000 ) {
    Future {
      blocking {
        println(i)
        Thread.sleep(999999)
      }
    }
  }
}
