import scala.collection.parallel.immutable.ParVector

val v = Vector.range(0, 10)
v.foreach(print)

val pv = ParVector.range(0, 10)
pv.foreach{x => Thread.sleep(100); print(x)}