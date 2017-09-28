
def solution(a: Array[Int]): Int = {
  val arNew: Array[Int] = Array.ofDim[Int](a.toList.max + 1)
  for (i <- arNew.indices) println(arNew(i))
  println()
  for (i <- a.indices) {
    arNew(a(i)) = arNew(a(i)) + 1
  }
  for (i <- arNew.indices) println(arNew(i))
  for (i <- arNew.indices) if (arNew(i) % 2 == 1) return i
  -1
}

solution(Array(9, 3, 9, 3, 9, 7, 9))
