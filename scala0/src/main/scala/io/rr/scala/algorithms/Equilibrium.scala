package io.rr.scala.algorithms

/**
  * @author roman on 7/27/17.
  */
object Equilibrium {
  def main(args: Array[String]): Unit = {
    def solution(a: Array[Int]): Int = {

      def diffAbs(a: Int, b: Int): Int = if (a - b < 0) b - a else a - b

      def findDiff(list: List[Int], leftSum: Int, rightSum: Int, diff: Int): Int = {
        list match {
          case x1 :: x2 :: xs =>
            val curDiff = diffAbs(leftSum, rightSum)
            val bestDiff = if (curDiff < diff) curDiff else diff
            findDiff(list.tail, leftSum + x1, rightSum - x1, bestDiff)
          case _ => diff
        }
      }

      val leftSum: Int = a(0)
      val rightSum: Int = a.sum - a(0)
      val diff = diffAbs(leftSum, rightSum)
      findDiff(a.toList.tail, leftSum, rightSum, diff)
    }

    val arr = Array[Int](-1, 3, -4, 5, 1, -6, 2, 1)
    println(solution(arr))

  }
}
