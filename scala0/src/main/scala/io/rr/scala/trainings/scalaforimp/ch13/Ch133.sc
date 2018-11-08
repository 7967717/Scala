val prices = List(5.0, 20.0, 9.95)
val quantities = List(10, 2, 1)
prices zip quantities

(prices zip quantities) map { p => p._1 * p._2 }

((prices zip quantities) map { p => p._1 * p._2 }) sum

List(5.0, 20.0, 9.95).zipAll(List(10, 2), 0.0, 1)

"Scala".zipWithIndex
"Scala".zipWithIndex.max
"Scala".zipWithIndex.max._2

def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)
val tenOrMore = numsFrom(10)
//tenOrMore.foreach(x => if (x < 20) println(x))
//tenOrMore.filter(_ < 20)foreach(x => println(x))
tenOrMore.tail
tenOrMore.tail.tail.tail

val squares = numsFrom(1).map(x => x * x)
squares.tail
squares.tail.tail
squares.take(5).force
squares.force

