//def solution(n: Int, s: String): Int = {
//  // write your code in Scala 2.12
//
//}

var s = "1A 2F 1C"
var b = s.split(" ").map(x => (x.charAt(0).toString.toInt, List(x.charAt(1).toString)))
//b.map(x => (x._1.toString.toInt, x._2))
def put(ar: Array[(Int, List[String])]) = {
  val map = scala.collection.mutable.Map[Int, List[String]]()
  for(elem <- ar) {
    if(map.contains(elem._1)) {
      val e = map(elem._1) ++ elem._2
      map.put(elem._1, e)
    } else map.put(elem._1, elem._2)
  }
  map
}

var map = put(b)

var a = Array("A", "B", "C", "D", "E", "F", "G", "H", "J", "K")
a.takeRight(3).contains("K")
//a.dropRight(3).takeRight(4)
//a.dropRight(7)
//a.map(x => if(x == "D") "0" else x)

def getSeats(list: List[String]) = {
  val a = Array("A", "B", "C", "D", "E", "F", "G", "H", "J", "K")
  for(elem <- list) {
    a.map(x => if(x == elem) "Z" else x)
  }
  val one = a.dropRight(7)
  val two = a.dropRight(3).takeRight(4)
  val three = a.takeRight(3)

  val one1 = if(one.contains("Z")) 0 else 3
//  val two1 = if(two(1) == "Z" || two(2) == "Z") 0
//  else if(two.)
  val three1 = if(three.contains("Z")) 0 else 3

}




