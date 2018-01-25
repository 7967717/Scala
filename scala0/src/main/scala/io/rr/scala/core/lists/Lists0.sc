

def isEmpty[A](l: List[A]): Boolean = l match {
  case Nil => true
  case x :: xs => false
}
def head[A](l: List[A]) = l match {
  case Nil => throw new Error("Nil.head")
  case x :: xs => x
}
def tail[A](l: List[A]) = l match {
  case Nil => throw new Error("Nil.tail")
  case x :: xs => xs
}

def take[A](n: Int, l: List[A]) =
  if (n == 0 || l.isEmpty) Nil else l.head :: l.tail.take(n-1)
def drop[A](n: Int, l: List[A]) =
  if (n == 0 || l.isEmpty) this else l.tail.drop(n-1)
def split[A](n: Int, l: List[A]) = (l.take(n), l.drop(n))

val x = 1 to 10
take(5, x.toList)
drop(5, x.toList)
split(5, x.toList)

def reverse[A](xs: List[A]): List[A] = xs match {
  case Nil => Nil
  case x :: xs => reverse(xs) ::: List(x)
}
reverse(x.toList)

def msort[A](less: (A, A) => Boolean)(xs: List[A]): List[A] = {
  def merge(xs1: List[A], xs2: List[A]): List[A] =
    if (xs1.isEmpty) xs2
    else if (xs2.isEmpty) xs1
    else if (less(xs1.head, xs2.head)) xs1.head :: merge(xs1.tail, xs2)
    else xs2.head :: merge(xs1, xs2.tail)
  val n = xs.length/2
  if (n == 0) xs
  else merge(msort(less)(xs.take(n)), msort(less)(xs.drop(n)))
}
msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3))
msort((x: Int, y: Int) => x > y)(List(5, 7, 1, 3))

def foreach[A](f: A => Unit)(xs: List[A]) {
  xs match {
    case Nil => ()
    case x :: xs => f(x); xs.foreach(f)
  }
}
foreach(println)(List(5, 7, 1, 3))