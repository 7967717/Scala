//100%
def solution(x: Int, y: Int, d: Int): Int = {
  val y1 = y - x
  y1 / d + (if(y1 % d != 0) 1 else 0)
}
solution(10, 85, 30)