def perm(s0: String)= {
  val s = s0.toVector.map(_.toString)
  val strings = for {
    a <- s
    b <- s
    c <- s
    d <- s
    e <- s
    if a != b && a != c && a != d && a != e &&
     b != c && b != d && b != e &&
     c != d && c != e &&
      d != e
  } yield a + b + c + d + e
  strings.toSet
}

perm("apple")

"apple".permutations.toVector


def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => if (n == 0) ys else y :: removeAt(n - 1, ys)
}
removeAt(1, List('a', 'b', 'c', 'd'))