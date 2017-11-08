import scala.collection.immutable.TreeSet

var a = TreeSet(1, 2, 3, 4, 5)
def printelems(list: List[Int]): Unit = list match {
  case Nil => println("Nil")
  case head :: tail =>
    println(head)
    printelems(tail)
}
printelems(a.toList)

def sum(list: List[Int], acc: Int): Int = list match {
  case Nil => acc
  case head :: tail => sum(tail, acc + head)
}
sum(a.toList, 0)

a.reduce(_ + _)
a.foreach(println)