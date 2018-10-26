import scala.util.Try

val a = Try

import scala.util.{Try, Success, Failure}

def divide(a: String, b: String): Try[Int] = {
  val dividend = Try(a.toInt)
  val divisor = Try(b.toInt)
  val problem = dividend.flatMap(x => divisor.map(y => x / y))
  problem
//  problem match {
//    case Success(v) =>
//      println("Result of " + dividend.get + "/" + divisor.get + " is: " + v)
//      Success(v)
//    case Failure(e) =>
//      println("You must've divided by zero or entered something that's not an Int. Try again!")
//      println("Info from the exception: " + e.getMessage)
//      Failure(e)
//  }
}

divide("2", "1")
divide("2", "a")