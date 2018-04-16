trait Equal[A] {
  def equal(a1: A, a2: A): Boolean
}

object Equal {
  def apply[A](implicit instance: Equal[A]): Equal[A] = instance

  implicit class EqualSyntax[A](a: A) {
    def equal(that: A)(implicit e: Equal[A]): Boolean =
      e.equal(a, that)
  }
}

implicit val intEqual: Equal[Int] =
  (a1: Int, a2: Int) => a1 == a2
println(Equal[Int].equal(1, 2))

import Equal.EqualSyntax
println(1 equal 2)


// is converted to
object TypeClass extends AnyRef with App {
  private val intEq: Equal[Int] =
    (a1: Int, a2: Int) => a1.==(a2)

  implicit def intEqual: Equal[Int] =
    TypeClass.this.intEq

  // substitution of an implicit parameter
  scala.Predef.println(Equal.apply[Int](TypeClass.this.intEqual).equal(1, 2))

  // implicit conversion to the required typeclass
  scala.Predef.println(Equal.EqualSyntax[Int](1).equal(2)(TypeClass.this.intEqual))
}