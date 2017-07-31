val a = "Mississippi".distinct
val b = "Rhine".permutations
val c = "Rhine".permutations.toArray
val e = "ABC".sum
try {
  val f = "A".toInt
} catch {
  case e: Exception =>
  //  case NumberFormatException
}
val g = "ABC".sum.toInt
val g1 = "ABC".sum
println(g1)
val g2 = g1.toInt
val g3 = '?'.toInt

val h = '1'
val h1 = h.toString

val n = 100.toString.toCharArray.permutations
  .map(_.mkString("")).map(_.toInt)
  .filter(_.toString.length == 3).toSet
val n1 = n.size
//val n1 = n.map(e -> e.toString)