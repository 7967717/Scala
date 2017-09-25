def squareList(xs: List[Int]): List[Int] =
  xs match {
    case Nil => xs
    case y :: ys => y * y :: squareList(ys)
  }

def squareList1(xs: List[Int]): List[Int] =
  xs map (x => x * x)

squareList(List(1,2,3))
squareList1(List(1,2,3))

List(-1, 1, -2, 2).partition(_ > 0)
List(1, 1, -2, -2).takeWhile(_ > 0)
List(1, 1, -2, -2).dropWhile(_ > 0)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val(first, rest) = xs.span(_ == x)
    first :: pack(rest)
}
pack(List(1,1,1,2,3,3,1))

def encode[T](xs: List[T]): List[(T,Int)] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val(first, rest) = xs.span(_ == x)
    (first.head, first.length) :: encode(rest)
}
pack(List(1,1,1,2,3,3,1)).map(x => (x.head, x.length))
encode(List(1,1,1,2,3,3,1))

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  xs.foldRight(List[U]())((x, y) => f(x) :: y)
mapFun(List(1,2,3), (x:Int) => x * x)

def lengthFun[T](xs: List[T]): Int =
  xs.foldRight(0)((x, y) => y + 1)
lengthFun(List(1,1,1,2,3,3,1))

(List(1) ++ List(2)).reverse
2 :: List(1).reverse