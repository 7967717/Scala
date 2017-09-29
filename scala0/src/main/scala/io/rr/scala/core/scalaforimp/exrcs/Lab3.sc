import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

val ar = ArrayBuffer(1, -1, 2, -2, 3, -3)
val ind = (for (i <- ar.indices if ar(i) < 0) yield i).drop(1)
for (i <- ind.reverse) ar.remove(i)
ar

val ar1 = ArrayBuffer(1, -1, 2, -2, 3, -3)
val (neg, pos) = ar1.partition(n => n < 0)
val res = pos += neg(0)


val words = ArrayBuffer("1", "1", "2", "2", "3", "4")
val count = new mutable.HashMap[String, Int]()
for (w <- words) {
  count(w) = count.getOrElse(w, 0) + 1
}
count
count("1")
count("3")
var count1 = new HashMap[String, Int]()
for (w <- words) {
  count1 = count1 + (w -> (count1.getOrElse(w, 0) + 1))
}
count1
