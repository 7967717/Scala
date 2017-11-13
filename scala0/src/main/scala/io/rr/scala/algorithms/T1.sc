def solution(n: Int, s: String): Int = {
  if (s.isEmpty) n * 9
  else {
    var acc = 0
    val map = stringToMap(s)
    for (i <- 1 to n) {
      if (map.contains(i)) acc = acc + getSeats(map(i)) else acc = acc + 9
    }
    acc
  }
}
solution(1, "")
solution(1, "1J")
solution(1, "1A 1J 1D")
solution(3, "1A 2J 2E 3G")

def stringToMap(s: String) = {
  s.split(" ").toList.groupBy(_.substring(0, 1))
    .map(x => (x._1.toInt, x._2.map(_.substring(1))))
}
stringToMap("1A 2F 1C 2G 1K")

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
getSeats(List("A", "K"))
getSeats(List("A", "D", "K"))
getSeats(List("A", "G", "K"))
getSeats(List("A", "E", "K"))
getSeats(List("A", "F", "K"))




