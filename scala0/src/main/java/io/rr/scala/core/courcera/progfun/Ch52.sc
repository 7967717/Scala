def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = xs.length / 2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, sn) => sn
        case (fs, Nil) => fs
        case (x :: fs, y :: sn) =>
          if (ord.lt(x, y)) x :: merge(fs, ys) else y :: merge(xs, sn)
      }

    val (fst, snd) = xs splitAt n
    merge(msort(fst), msort(snd))
  }
}

val nums = List(1, -1, 5, 2, 0, 4, 3)
val fruits = List("org", "bnn", "pnp","app")
msort(nums)
msort(fruits)