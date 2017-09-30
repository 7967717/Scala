//100%
def solution(a: Array[Int]): Int = {

  // variant 1
//  var prev = 0
//  if (a.length != 0) {
//    val arr = a.sorted
//    for (i <- arr) {
//      prev = prev + 1
//      if (prev != i) {
//        return prev
//      }
//    }
//  }
//  prev + 1

  // variant 2
  val length = a.length
  val sum: Long = (length + 1L) * (length + 2) / 2
  def loop (a: Array[Int], acc: Long, i: Int): Int = {
    if (i == length) acc.asInstanceOf[Int]
    else loop(a, acc - a(i), i + 1)
  }
  loop(a, sum, 0)
}

solution(Array()) //1
solution(Array(1))//2
solution(Array(2))//1
solution(Array(2, 3, 5, 4))//1
solution(Array(2, 3, 1, 4))//5
solution(Array(2, 3, 1, 5))//4