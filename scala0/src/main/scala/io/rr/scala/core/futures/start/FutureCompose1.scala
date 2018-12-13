package io.rr.scala.akka.future

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}


object FutureCompose1 extends App {

  val f1 = Future(1)
//    val f1 = Future(throw new Exception)
//  val f2 = Future(2)
  val f2 = Future(throw new Exception)


  val res: Future[Cont] = f1.flatMap(a => f2
    .map(b => Cont(Right(a), Right(b)))
    .recover {
      case e2: Exception => Cont(Right(a), Left(e2))
    }
  )
    .recover {
    case e1: Exception => Cont(Left(e1), Left(e1))
  }

  println("-----")

  Thread.sleep(1000)


  res.onComplete {

    case Success(x) =>
      println(x.a.toString, x.b.toString)
      println("sss")
    case Failure(e) => println(e)
      println("fff")
  }

  println("-----")


}

case class Cont(a: Either[Exception, Int], b: Either[Exception, Int])