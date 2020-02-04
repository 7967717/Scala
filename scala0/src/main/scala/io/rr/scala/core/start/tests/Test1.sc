

class B(val b: Int)
class A(a: Int)
//the same as above
class C(private val c: Int)
val b = new B(2)
b.b
val a = new A(1)
//a.a
val c = new C(3)
//c.c

val m1 = Map(1 -> "1", 2 -> "2", 3 -> "3")
//val m1 = Map()
//val m2 = Map(1 -> "1", 5 -> "5", 6 -> "6")
val m2 = Map[Int, String]()
m1 ++ m2

m1.foldLeft(m2)(add)

def add(m: Map[Int, String], e: (Int, String)) = {
  val(k, v) = e
  m + (k -> (v + m.getOrElse(k, "")))
}