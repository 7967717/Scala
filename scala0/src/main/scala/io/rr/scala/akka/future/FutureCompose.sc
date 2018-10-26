import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

object NetworkException extends Throwable

def networkRequest(): Future[String] = {
  // let's assume a high rate of failure to make our examples
  // more interesting
  if ((Random.nextFloat * 100) < 80)
    Future.failed(NetworkException)
  else
    Future.successful("<data>")
}

def networkRequestWithRetries(): Future[String] = {
  networkRequest().recoverWith {
    case NetworkException =>
      println("retrying")
      networkRequestWithRetries()
    case t: Throwable => throw t
  }
}
networkRequestWithRetries()

import akka.actor.ActorSystem
import akka.pattern.Patterns.after
import scala.concurrent.duration._

val as = ActorSystem()

val x = after(2.seconds, as.scheduler, global, Future.successful(1)).flatMap { _ =>
  Future {
    // long operation that _starts_ after the delayed future completes
    1
  }
}

def networkRequestWithRetries1()(implicit as: ActorSystem): Future[String] = {
  networkRequest().recoverWith {
    case NetworkException =>
      println("retrying")
      after(2.seconds, as.scheduler, global, Future.successful(1)).flatMap { _ =>
        networkRequestWithRetries1()
      }
    case t: Throwable => throw t
  }
}



networkRequestWithRetries1()(as)
