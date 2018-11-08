import scala.io.Source

val words = Source.fromFile("C:\\Users\\rrudenko\\IdeaProjects\\Scala\\scala0\\src\\main\\resources\\myfile.txt").getLines.toStream
words
words(3)
words


val palindromicSquares = (1 to 1000000).view
  .map(x => x * x)
  .filter(x => x.toString == x.toString.reverse)
palindromicSquares.take(10).mkString(",")

val palindromicSquares0 = (1 to 1000000).view
  .map(x => x * x)
palindromicSquares0.take(10).mkString(",")

import scala.collection.JavaConversions._

val props: scala.collection.mutable.Map[String, String] = System.getProperties()



