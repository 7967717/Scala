//100%
def solution(n: Int): Int = {
  val b = n.toBinaryString.toList
  def loop (chars: List[Char], acc: Int, ints: List[Int]): List[Int] = {
    chars match {
      case Nil => ints
      case x :: xs =>
        if (x == '0') loop(xs, acc + 1, ints)
        else loop(xs, 0, acc :: ints)
    }
  }
  loop(b, 0, List()).max
}

1.toBinaryString
solution(1)
2.toBinaryString
solution(2)
3.toBinaryString
solution(3)
9.toBinaryString
solution(9)
15.toBinaryString
solution(15)
20.toBinaryString
solution(20)
529.toBinaryString
solution(529)
1041.toBinaryString
solution(1041)
1234.toBinaryString
solution(1234)
12345.toBinaryString
solution(12345)
123456.toBinaryString
solution(123456)

