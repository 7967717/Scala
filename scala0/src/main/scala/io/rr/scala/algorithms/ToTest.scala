package io.rr.scala.algorithms

/**
  * @author rrudenko on 27.09.2017.
  */
object ToTest {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable

    def solution(n: Int, s: String): Int = {
      if (s.isEmpty) n * 9
      else {
        var acc = 0
        val map = stringToMap(s)
        for (i <- 1 to n) {
          if (map.contains(i))
            acc = acc + getSeats(map(i))
            else acc = acc + 9
        }
        acc
      }
    }
    println(solution(2, "2A"))

    def stringToMap(s: String) = {
      val ar = s.split(" ").map(x => (x.charAt(0).toString.toInt,
        List(x.charAt(1).toString)))
      val map = mutable.Map[Int, List[String]]()
      for (elem <- ar) {
        if (map.contains(elem._1)) {
          val e = map(elem._1) ++ elem._2
          map.put(elem._1, e)
        } else map.put(elem._1, elem._2)
      }
      map
    }

    def getSeats(list: List[String]) = {
      val a = Array("A", "B", "C", "D", "E", "F", "G", "H", "J", "K")
      for {e <- list
           n <- a.indices} {
        if (a(n) == e) a(n) = "X"
      }
      val left = a.dropRight(7)
      val center = a.dropRight(3).takeRight(4)
      val right = a.takeRight(3)

      val l = if (!left.contains("X")) 3 else 0
      val cl = center.takeRight(3)
      val cr = center.dropRight(1)
      val c = if (!cl.contains("X") || !cr.contains("X")) 3 else 0
      val r = if (!right.contains("X")) 3 else 0
      l + c + r
    }
  }
}
