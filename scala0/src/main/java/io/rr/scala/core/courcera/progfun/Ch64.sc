import scala.io.Source

val fruits = List("org", "bnn", "pnp", "app", "pear")
fruits.sortBy(_.head)
fruits.sorted
fruits.groupBy(_.head)

val in = Source.fromFile("\\linuxwords.txt")

val words = in.getLines.toList


val mnem = Map('2' -> "ABC", '3' -> "DEF")
val charCode: Map[Char, Char] =
  for ((digit, str) <- mnem; ltr <- str) yield ltr -> digit