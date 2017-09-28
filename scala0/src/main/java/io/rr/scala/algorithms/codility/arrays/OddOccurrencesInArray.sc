
def solution(a: Array[Int]): Int = {
//  def loop(arr: Array[Int], x: Int, y: Int): Int = {
//    if (a(x) == a(y)) loop(arr, x + 1, y + 1)
//    else a(y)
//  }
//  loop(a, 0, 2)
  a.toSet.last
}


def solution3(a: Array[Int]): Int = {
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
solution3(Array(9, 3, 9, 3, 9, 7, 9))