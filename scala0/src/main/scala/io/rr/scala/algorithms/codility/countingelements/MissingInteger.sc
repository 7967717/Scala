// 100%
def solution(a: Array[Int]): Int = {
  def loop(in: Int, l: List[Int]): Int = {
    if (l.isEmpty || l.head != in) in
    else loop(in + 1, l.tail)
  }
  loop(1, a.toList.filter(_ > 0).distinct.sorted)
}
solution(Array(1, 3, 6, 4, 1, 2))//5
solution(Array(1, 2, 3))//4
solution(Array(-1, -2, -3))//1