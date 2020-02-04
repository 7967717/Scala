def fib(n: Long): Long = n match {
  case 0 | 1 => n
  case _ => fib(n - 1) + fib(n - 2)
}

fib(0)
fib(1)
fib(2)
fib(3)
fib(20)

import scala.math.BigInt

val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }

fibs.take(11).toList.last
fibs.take(51).toList.last
fibs.take(101).toList.last

val fibs1: Stream[BigInt] = BigInt(0) #:: fibs1.scanLeft(BigInt(1))(_ + _)
fibs1.take(4).foreach(println(_))
fibs1.take(3).toList.last
fibs1.take(51).toList.last
fibs1.take(101).toList.last