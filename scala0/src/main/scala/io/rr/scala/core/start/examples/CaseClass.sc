case class A(note: String)
val a = A("note")
a.note

class B(note: String)
val b = new B("note")
//b.note is private

class C(_note: String){ val note: String = ""}
val c = new C("note")
c.note
//c._note is private