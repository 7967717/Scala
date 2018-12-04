import scala.io.Source

val fruits = List("org", "bnn", "pnp", "app", "pear")
fruits.sortBy(_.head)
fruits.sorted
fruits.groupBy(_.head)

val url = Source.getClass.getClassLoader.getResource("courcera/linuxwords.txt")
val in = Source.fromURL(url)
val words = in.getLines.toList.filter(word => word.forall(ch => ch.isLetter))

val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
                '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

val charCode: Map[Char, Char] =
  for ((digit, str) <- mnem; ltr <- str) yield ltr -> digit
charCode.toList.sorted

def wordCode(word: String): String = {
  word.toUpperCase.map(charCode)
}
wordCode("Java")

val wordsForNum: Map[String, Seq[String]] = {
  words.groupBy(word => wordCode(word)).withDefaultValue(Seq())
}

def encode(number: String): Set[List[String]] = {
  if (number.isEmpty) Set(List())
  else
    for {
      split <- 1 to number.length
      word <- wordsForNum(number.take(split))
      rest <- encode(number.drop(split))
  } yield word :: rest
}.toSet
encode("7225247386")

def translate(number: String) =
encode(number).map(_.mkString(" "))
translate("7225247386")