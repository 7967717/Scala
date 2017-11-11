package io.rr.scala.algorithms

/**
  * @author rrudenko on 27.09.2017.
  */
object ToTest {
  def main(args: Array[String]) {
    //    def solution(a: Array[Int]): Int = {
    //      //  val sorted = Sorting.quickSort(a)
    //      def loop(arr: Array[Int], x: Int, y: Int): Int = {
    //        if (x == y) loop(arr, arr(x + 1), arr(y + 1))
    //        else y
    //      }
    //
    //      loop(a, a(0), a(2))
    //    }
    //
    //    solution(Array(9, 3, 9, 3, 9, 7, 9))


    def contains(list: Seq[String], word: String): Boolean = {
      val middle = list.length / 2
      if (list.isEmpty) false
      else if (word < list(middle)) {
        val l = list.dropRight(middle)
        contains(l, word)
      }
      else if (word > list(middle)) {
        val l = list.takeRight(middle)
        contains(l, word)
      }
      else true
    }

    val list = List("one", "two", "three", "four", "five")
//    contains(list.sorted, "one")
//    contains(list.sorted, "three")
    contains(list.sorted, "ones")
  }
}
