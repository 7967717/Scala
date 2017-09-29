def solution(a: Array[Int]): Int = {
  var prev = 0
  if (a.length != 0) {
    val arr = a.sorted
    for (i <- arr) {
      prev = prev + 1
      if (prev != i) {
        return prev
      }
    }
  }
  prev + 1
}

solution(Array()) //1
solution(Array(1))//2
solution(Array(2))//1
solution(Array(2, 3, 5, 4))//1
solution(Array(2, 3, 1, 4))//5
solution(Array(2, 3, 1, 5))//4