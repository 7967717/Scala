//def abs(x:Double) = if (x < 0) -x else x
//
//def sqrtIter(guess: Double, x: Double): Double =
//  if (isGoodEnough(guess, x)) guess
//  else sqrtIter(improve(guess, x), x)
//
//def isGoodEnough(guess: Double, x: Double) = ???
//
//def improve(guess: Double, x: Double) = (guess + x / guess) / 2
//
//def sqrt(x: Double) = sqrtIter(1.0, x)

//def sum(xs: List[Int]): Int = {
////  xs match {
////    case x :: tail => x + sum(tail) // if there is an element, add it to the sum of the tail
////    case isEmpty => 0 // if there are no elements, then the sum is 0
////  }
//}

def max(xs: List[Int]): Int =
//  xs match {
//    case Nil => throw new java.util.NoSuchElementException ("the list is empty")
//    case List(x: Int) => x
//    case x :: y :: rest => max( (if (x > y) x else y) :: rest )
//  }

  if (xs.isEmpty) throw new java.util.NoSuchElementException ("the list is empty")
  else max0(xs.tail, xs.head)

    def max0 (xs: List[Int], max: Int): Int =
      if (xs.isEmpty) max else
        if (max >= xs.head) max0(xs.tail, max) else max0(xs.tail, xs.head)



val xs = List(5, 6, 7)
  xs.tail
  xs.isEmpty
  xs.head

max(xs)