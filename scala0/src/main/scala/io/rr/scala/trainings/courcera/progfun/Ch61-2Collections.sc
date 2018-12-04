(1 to 2).flatMap(x => (1 to 2).map(y => (x, y)))

def isPrime(n: Int): Boolean = {
  (2 until n).forall(d => (n % d) != 0)
}
isPrime(1)
isPrime(2)
isPrime(3)
isPrime(4)
isPrime(5)
isPrime(6)

val n = 7
(1 until n).flatMap(i => (1 until i).map(j => (i, j)))
  .filter(x => isPrime(x._1 + x._2))
//the same
for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
}
  yield (i, j)

def scalarProducts(xs: List[Double], ys: List[Double]): Double =
  (for((x, y) <- xs zip ys) yield x * y).sum

