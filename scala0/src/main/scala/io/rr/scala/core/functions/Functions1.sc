val plus1: (Int => Int) = (x: Int) => x + 1
plus1(2)

val plus2: Function1[Int, Int] = new Function1[Int, Int] {
  def apply(x: Int): Int = x + 1
}
plus2.apply(2)

val tostr: Function1[Int, String] = new Function1[Int, String] {
  def apply(x: Int): String = x.toString
}
tostr(1)