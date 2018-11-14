
class A(a: Int)
class B(val b: Int)
class C(private val c: Int)
val a = new A(1)
//a.a
val b = new B(2)
b.b
val c = new C(3)
//c.c