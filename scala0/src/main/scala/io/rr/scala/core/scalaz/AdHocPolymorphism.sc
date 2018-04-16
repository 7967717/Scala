trait FoldLeft[M[_]] {
  def foldLeft[A, B] (l: M[A], z: B, f: (B, A) => B): B
}

object FoldLeft {
  implicit object FoldLeftList extends FoldLeft[List] {
    def foldLeft[A, B](l: List[A], z: B, f: (B, A) => B): B = l.foldLeft(z)(f)
  }
}

trait Monoid[T] {
  def mappend(a: T, b: T): T
  def mzero: T
}

object Monoid {
  implicit object IntMonoid extends Monoid[Int] {
    override def mappend(a: Int, b: Int) = a + b
    override def mzero = 0
  }

  implicit object StringMonoid extends Monoid[String] {
    override def mappend(a: String, b: String) = a + b
    override def mzero = ""
  }

}

def sum[M[_], T](l: M[T])(implicit m: Monoid[T], f: FoldLeft[M]): T =
  f.foldLeft(l, m.mzero, m.mappend)

sum(List(1, 2, 3, 4))
sum(List("1", "2", "3", "4"))
