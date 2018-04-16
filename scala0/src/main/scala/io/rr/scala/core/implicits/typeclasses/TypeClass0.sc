trait Pure[P[_]] {
  def pure[A](a: => A): P[A]
}

implicit def Tuple1Pure = new Pure[Tuple1] {
  def pure[A](a: => A) = Tuple1(a)
}

//1.pure[Tuple1]

Tuple1Pure.pure(1)
implicitly[Pure[Tuple1]]
implicitly[Pure[Tuple1]].pure(1)
