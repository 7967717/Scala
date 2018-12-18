package io.rr.scala.core.futures.start.executioncontext

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global

object Future01 {
  def startTask(number: Int): Future[Unit] = Future {
//    blocking { //the global execution context is “blocking” aware and starts extra threads
      debug(s"Starting task#$number")
      Thread.sleep(2000) // wait 2secs
      debug(s"Finished task#$number")
//    }
  }

  def main(args: Array[String]): Unit = {
//  to change Threads# add  -Dscala.concurrent.context.maxThreads=3  to VM options
    println(s"Number of threads - $maxNoOfThreads")
    debug("Starting Main")
    val tasks = Future.traverse(1 to 20)(startTask)
    debug("Continuing Main")
    // waits for all tasks to complete before exiting
    Await.result(tasks, Duration.Inf)
  }

  def debug(message: String): Unit = {
    val now = java.time.format.DateTimeFormatter.ISO_INSTANT
      .format(java.time.Instant.now)
      .substring(11, 23) // keep only time component
    val thread = Thread.currentThread.getName()
    println(s"$now [$thread] $message")
  }

  def getInt(name: String, default: String) = (
    try System.getProperty(name, default) catch {
      case e: SecurityException => default
    }
    ) match {
    case s if s.charAt(0) == 'x' =>
      (Runtime.getRuntime.availableProcessors * s.substring(1).toDouble).ceil.toInt
    case other => other.toInt
  }

  val maxNoOfThreads = getInt("scala.concurrent.context.maxThreads", "x1")

}
