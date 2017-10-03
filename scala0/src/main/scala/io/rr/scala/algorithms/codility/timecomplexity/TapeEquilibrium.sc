//100%
def solution(a: Array[Int]): Int = {
  val sum = a.sum

  def getDiff(sumLeft: Int, sumRight: Int): Int = Math.abs(sumLeft - sumRight)

  def findEq(p: Int, sumLeft: Int, curMin: Int): Int =
    if (p == a.length) curMin
    else findEq(p + 1, sumLeft + a(p - 1), Math.min(curMin, getDiff(sumLeft, sum - sumLeft)))

  findEq(2, a(0), getDiff(a(0), sum - a(0)))
}

solution(Array(3, 1, 2, 4, 3))