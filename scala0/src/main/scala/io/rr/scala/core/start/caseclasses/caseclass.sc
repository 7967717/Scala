case class A(val v: Int)
val a = A(0)
a.v

case class B(v: Int) // the same as val v: Int
val b = B(0)
b.v
//b.v = 1  reassignment to val

class C(v: Int){}
val c = new C(0)
//c.v not visible