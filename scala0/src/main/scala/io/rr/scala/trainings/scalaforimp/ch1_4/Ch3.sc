val nums = new Array[Int](10)
nums(0)
val a0 = new Array[String](10)
val s = Array("Hello", "World")
s(0) = "Goodbye"
s

import scala.collection.mutable.ArrayBuffer
val b = ArrayBuffer[Int]()
b += 1
b += (1, 2, 3, 5)
b ++= Array(8, 13, 21)
b.trimEnd(5)
b
b.insert(2, 6)
b
b.insert(2, 7, 8, 9)
b
b.remove(2)
b
b.remove(2, 3)
b
b.toArray

for(i <- b.indices)
  println(b(i))

for(i <- b.indices.reverse)
  println(b(i))

for (elem <- b.reverse)
println(elem)

val a = Array(2, 3, 6, 7, 11)

val result = for (elem <- a) yield 2 * elem
for (elem <- a if elem % 2 == 0) yield 2 * elem
a
println("the same")
a.filter(_ % 2 == 0).map(2 * _)
a

val c = Array(2, -3, 6, -7, -11)
val res = for(elem <- c if elem < 0) yield elem

Array(1, 7, 2, 9).sum
ArrayBuffer("Mary", "had", "a", "little", "lamb").max

val b0 = ArrayBuffer(1, 7, 2, 9)
b0.sorted
b0
b0.sortWith(_ > _)
b0.sortWith(_ < _)

val a1 = Array(1, 7, 2, 9)
a1.sorted

a1.mkString(" and ")
a1.mkString("<", ",", ">")


a1.toString
b0.toString

c.count(_ > 0)
val s0 = "World"
s0.containsSlice("el")
s0.containsSlice("le")
s0.sorted
s0.sortWith(_ < _)

val matrix = Array.ofDim[Double](3, 4)

val z = java.util.TimeZone.getAvailableIDs
z.filter(_.startsWith("America"))
  .map(_.substring("America/".length))
  .sortWith(_ > _)

import java.awt.datatransfer._

val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]







