
def solution(a: Array[Int]): Int = {
  def loop(arr: Array[Int], x: Int, y: Int): Int = {
    if (a(x) == a(y)) loop(arr, x + 1, y + 1)
    else a(y)
  }
  loop(a, 0, 2)
}

solution(Array(9, 3, 9, 3, 9, 7, 9))