def sqrt(x: Double) = {
  def sqrtIter(guess: Double): Double = {
    if(isGood(guess)) guess
    else sqrtIter(improve(guess))
  }
  import scala.math._
  def isGood(guess: Double) = {
    if (abs(guess * guess - x) / x < 0.0001 ) true
    else false
  }

  def improve(guess: Double) = {
    ((x / guess) + guess) /2
  }

  sqrtIter(1)
}

sqrt(2)
sqrt(4)
sqrt(1e-6)
sqrt(0.000001)
sqrt(1e10)
sqrt(10000000000L)