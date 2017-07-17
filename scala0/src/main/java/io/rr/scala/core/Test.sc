import scala.annotation.tailrec

def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)

gcd(14, 21)

def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

factorial(10)

def tailfact(n: Int): Long = {
  @tailrec
  def tail(acc: Long, x: Int): Long = {
    if (x == 0) acc else tail(acc * x, x - 1)
  }
  tail(1L, n)
}

tailfact(100)


