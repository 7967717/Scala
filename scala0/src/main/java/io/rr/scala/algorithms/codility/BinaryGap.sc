//def solution(n: Int): Int = {
//  val b = n.toBinaryString
//  var m: Map[String, Int] = Map()
//  for {
//    ch <- b
//    m + (m.getOrElse(ch)
//  }
//}

9.toBinaryString
val chars = 529.toBinaryString.toList
chars.map(x => (x, chars.count(_ == x)))