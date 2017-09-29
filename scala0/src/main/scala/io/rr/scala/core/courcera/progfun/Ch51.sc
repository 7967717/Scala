def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => Nil
  case y :: ys => y :: init(ys)
}
init(List(1, 2, 3))

def removeAt[T](n: Int, xs: List[T]) = {
  (xs take n) ::: (xs drop n + 1)
}
removeAt(1, List('a', 'b', 'c', 'd')) // List(a, c, d)

def flatten(xs: List[Any]): List[Any] = xs match {
  case List() => List()
  case head :: tail => (head match {
    case l: List[Any] => flatten(l)
    case x => List(x)
  }) ::: flatten(tail)
}
flatten(List(List(1, 1), 2, List(3, List(5, 8))))

