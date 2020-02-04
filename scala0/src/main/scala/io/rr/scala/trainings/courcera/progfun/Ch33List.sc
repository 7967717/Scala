trait List[+T] {
  def prepend[U >: T](elem: U): List[U] = Cons(elem, this)
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}
case class Cons[T](h: T, t: List[T]) extends List[T] {
  override def isEmpty = false
  override def head = h
  override def tail = t
}
case object Nil extends List[Nothing] {
  override def isEmpty = true
  override def head = throw new NoSuchElementException
  override def tail = throw new NoSuchElementException
}

def nth[T](n: Int, list: List[T]): T = {
  if (list.isEmpty) throw new IndexOutOfBoundsException
  else if (n == 0) list.head
  else nth(n - 1, list.tail)
}

val v = Cons(1, Cons(2, Cons(3, Nil)))
nth(2 , v)
nth(1, Nil)