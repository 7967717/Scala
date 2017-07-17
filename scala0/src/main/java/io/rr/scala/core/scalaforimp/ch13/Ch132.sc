import scala.collection.mutable.ArrayBuffer

val names = List("Peter", "Paul", "Mary")
names.map(_.toUpperCase)

def ulcase(s: String) = Vector(s.toUpperCase(), s.toLowerCase())

names.map(ulcase)
names.flatMap(ulcase)

val buffer = ArrayBuffer("Peter", "Paul", "Mary")
buffer.transform(_.toUpperCase)
buffer.map(_.toUpperCase) // the same

names.foreach(println)
"-3+4".collect {
  case '+' => 1 ;
  case '-' => -1
}

"Hhh 111".collect {
  case 'h' => 0;
  case '1' => 1;
}

val words = List("peter", "paul", "mary")

val map = words.groupBy(_.substring(0, 1).toUpperCase())

List(1, 7, 2, 9).reduceLeft(_ - _)
var x = ((1 - 7) - 2) - 9 //the same

List(1, 7, 2, 9).reduceRight(_ - _)

List(1, 7, 2, 9).foldLeft(0)(_ - _)
(0 /: List(1, 7, 2, 9))(_ - _) //the same

List(1, 7, 2, 9).foldLeft("")(_ + _)

val freq = scala.collection.mutable.Map[Char, Int]()
for (c <- "Mississippi") freq(c) = freq.getOrElse(c, 0) + 1
freq

var frek = scala.collection.mutable.Map[Char, Int]()
frek = ( frek /: "Mississippi") {
  (m, c) => m + (c -> (m.getOrElse(c, 0) + 1))
}
freq == frek

(1 to 10).scanLeft(0)(_ + _)