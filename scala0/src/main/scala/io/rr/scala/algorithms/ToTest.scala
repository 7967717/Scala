package io.rr.scala.algorithms

/**
  * @author rrudenko on 27.09.2017.
  */
object ToTest {
  def main(args: Array[String]) {
    def solution(a: Array[Int]): Int = {
      //  val sorted = Sorting.quickSort(a)
      def loop(arr: Array[Int], x: Int, y: Int): Int = {
        if (x == y) loop(arr, arr(x + 1), arr(y + 1))
        else y
      }

      loop(a, a(0), a(2))
    }

    solution(Array(9, 3, 9, 3, 9, 7, 9))
  }
}
