//100%
def solution(a: Array[Int]): Int = {
  var expected = 0
  if (a.length == 0) return 0
  else {
    val arr = a.sorted
    for (i <- arr) {
      expected += 1
      if (expected != i)
        return 0
    }
  }
  1
}
solution(Array())
solution(Array(0))
solution(Array(1))
solution(Array(1, 2))
solution(Array(4, 1, 3, 2))
solution(Array(4, 1, 3))
solution(Array(5, 3, 2, 1, 4))

