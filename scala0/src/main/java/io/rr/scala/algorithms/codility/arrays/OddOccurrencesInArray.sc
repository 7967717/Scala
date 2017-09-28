
def solution(a: Array[Int]): Int = {
//  def loop(arr: Array[Int], x: Int, y: Int): Int = {
//    if (a(x) == a(y)) loop(arr, x + 1, y + 1)
//    else a(y)
//  }
//  loop(a, 0, 2)
  a.toSet.last
}


def solution3(A: Array[Int]): Int = {
  val ar: Array[Int] = Array.ofDim[Int](A.toList.max + 1)
  for (i <- ar.indices) println(i)
  for (i <- A.indices) {
    ar(A(i)) = ar(A(i)) + 1
    println(i, " " + ar(A(i)))
  }
  for (i <- ar.indices) if (ar(i) % 2 == 1) return i
  -1
}

solution(Array(9, 3, 9, 3, 9, 7, 9))
solution3(Array(9, 3, 9, 3, 9, 7, 9))