import scala.collection.SortedSet
import scala.collection.mutable.ArrayBuffer

val coll0 = List(0, 3, 6, 9)
val range = 0 to 9
val iter = coll0.iterator
val iterR = range.iterator
while (iter.hasNext) println(iter.next())
while (iterR.hasNext) println(iterR.next())

SortedSet("Hello", "World")
SortedSet.apply("Hello", "World")

val coll = Seq(1, 1, 2, 3, 5, 8, 13)
val set = coll.toSet
val buffer = coll.to[ArrayBuffer]

Seq(1, 2, 3) == (1 to 3)
Seq(1, 2, 3) == Set(1, 2, 3)
Seq(1, 2, 3).sameElements(Set(1, 2, 3))

def digits0(n: Int): Set[Int] =
  if (n < 0) digits0(-n)
  else if (n < 10) Set(n)
  else digits0(n / 10) + (n % 10)

digits0(1000)

val digits = List(4, 2)
digits.head
digits.tail

9 :: List(4, 2)
9 :: 4 :: 2 :: Nil

def sum(lst: List[Int]): Int =
  if (lst == Nil) 0 else lst.head + sum(lst.tail)
sum(digits)

def sum0(lst: List[Int]): Int = lst match {
  case Nil => 0
  case h :: t => h + sum0(t) // h is lst.head, t is lst.tail
}
sum0(digits)

List(9, 4, 2).sum
