//100%
def solution(x: Int, a: Array[Int]): Int = {
  var path: Set[Int] = Set()
  for (i <- a.indices) {
    path += a(i)
    if (path.size == x)
      return i
  }
  -1
}