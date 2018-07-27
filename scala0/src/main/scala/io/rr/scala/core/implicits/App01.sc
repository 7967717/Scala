
implicit val s0: String = "test"
implicitly[String]

implicit def emptyList[T]: List[T] = List.empty[T]
implicitly[List[String]]
implicitly[List[Int]]

implicit val i: Int = 0
implicit def streamOfT[T](implicit value: T): Stream[T] =
  Stream.continually(value)

implicitly[Stream[String]]
implicitly[Stream[Int]]