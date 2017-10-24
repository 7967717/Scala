def fib(n: Int): Int = n match {
  case 0 | 1 => n
  case _ => fib(n - 1) + fib(n - 2)
}

fib(0)
fib(1)
fib(2)
fib(3)
fib(30)

import scala.math.BigInt
val fibs: Stream[BigInt] = BigInt(0) #::
  BigInt(1) #::
  fibs.zip(fibs.tail).map { n => n._1 + n._2 }

fibs.take(10).foreach(println(_))

val fibs1: Stream[Int] = 0 #:: fibs1.scanLeft(1)(_ + _)
fibs1.take(10).foreach(println(_))