val nums = new Array[Int](10)
nums(0)
val a = new Array[String](10)
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