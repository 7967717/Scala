def solution(array: Array[Int], k: Int): Array[Int] = {
  def rotate(a: Array[Int]): Array[Int] = {
    val arNew: Array[Int] = a.clone()
    for (i <- a.indices) {
      if (i == a.length - 1) arNew(0) = a(i)
      else arNew(i + 1) = a(i)
    }
    arNew
  }
  def loop(ar: Array[Int], n: Int): Array[Int] = {
    if (n == 0) ar
    else loop(rotate(ar), n - 1)
  }
  loop(array, k)
}

solution(Array(3, 8, 9, 7, 6), 1)
solution(Array(3, 8, 9, 7, 6), 3)