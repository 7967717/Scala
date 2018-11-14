abstract class List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}
class Cons[+T](val h: T, val t: List[T]) extends List[T] {
  override def isEmpty = false
  override def head = h
  override def tail = t
}
object Nil extends List[Nothing] {
  override def isEmpty = true
  override def head = throw new NoSuchElementException
  override def tail = throw new NoSuchElementException
}

def nth[T](n: Int, list: List[T]): T = {
  if (list.isEmpty) throw new IndexOutOfBoundsException
  else if (n == 0) list.head
  else nth(n - 1, list.tail)
}

val v = new Cons(1, new Cons(2, new Cons(3, Nil)))
nth(2 , v)
nth(1, Nil)