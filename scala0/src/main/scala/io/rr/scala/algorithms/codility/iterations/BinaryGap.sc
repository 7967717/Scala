def solution(n: Int): Int = {
  val b = n.toBinaryString.toList
  def loop (chars: List[Char], acc: Int, ints: List[Int]): List[Int] = {
    chars match {
      case Nil => acc :: ints
      case x :: xs =>
        if (x == '0') loop(xs, acc + 1, ints)
        else loop(xs, 0, acc :: ints)
    }
  }
  loop(b, 0, List()).max
}

solution(1)
solution(2)
solution(3)
solution(9)
solution(15)
solution(529)
solution(1041)
solution(1234)
solution(12345)
solution(123456)
solution(1234567)
solution(12345678)
solution(123456789)
solution(1234567890)

1.toBinaryString
2.toBinaryString
3.toBinaryString
9.toBinaryString
15.toBinaryString
529.toBinaryString
1041.toBinaryString
1234.toBinaryString
12345.toBinaryString
123456.toBinaryString
1234567.toBinaryString
12345678.toBinaryString
123456789.toBinaryString
1234567890.toBinaryString
