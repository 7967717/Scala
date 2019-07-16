import scala.annotation.tailrec

def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(_) => Nil
  case y :: ys => y :: init(ys)
}
init(List(1, 2, 3))

def reverse[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => reverse(ys) ++ List(y)
}
reverse(List(1, 2, 3))

def reverse1[T](xs: List[T]): List[T] = {
  @tailrec
  def go(ys: List[T], xs: List[T]) : List[T] = ys match {
    case List() => xs
    case z :: zs => go(zs, z :: xs)
  }
  go(xs.tail, List(xs.head))
}
reverse1(List(1, 2, 3, 4))

def removeAt0[T](n: Int, xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => if (n == 0) ys else y :: removeAt(n - 1, ys)
}
removeAt0(1, List('a', 'b', 'c', 'd'))

def removeAt[T](n: Int, xs: List[T]) = {
  (xs take n) ++ (xs drop n + 1)
}
removeAt(1, List('a', 'b', 'c', 'd')) // List(a, c, d)

def flatten0(xs: List[Any]): List[Any] = xs match {
  case List() => List()
  case y :: ys => y match {
    case z :: zs => z :: flatten0(zs) ::: flatten0(ys)
    case _ => y :: flatten0(ys)
  }
}

flatten0(List(List(1, 1), 2, List(3, List(5, 8))))

def flatten(xs: List[Any]): List[Any] = xs match {
  case List() => List()
  case head :: tail => (head match {
    case l: List[Any] => flatten(l)
    case x => List(x)
  }) ::: flatten(tail)
}
flatten(List(List(1, 1), 2, List(3, List(5, 8))))

