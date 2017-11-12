def intPermutation(n: Int): Int = {
  n.toString
    .toCharArray
    .permutations
    .map(_.mkString(""))
    .map(_.toInt)
    .filter(_.toString.length == n.toString.length)
    .toSet
    .size
}

1 == intPermutation(0)
6 == intPermutation(123)
12 == intPermutation(1231)
1 == intPermutation(100)

intPermutation(6)
intPermutation(1213)

