package io.rr.scala.core.futures.start

import scala.concurrent.{ExecutionContext, Future, blocking}

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
