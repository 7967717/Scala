// returns a List consisting of all but the last element
def init[A](l: List[A]): List[A] =
  l match {
    case Nil => sys.error("init of empty list")
    case _ :: Nil => Nil
    case h :: t => h :: init(t)
  }
init(List(1, 2, 3, 4))


def dropWhile[A](as: List[A])(f: A => Boolean): List[A] =
  as match {
    case h :: t if f(h) => dropWhile(t)(f)
    case _ => as
  }
val xs: List[Int] = List(1, 2, 3, 4, 5)
val ex1 = dropWhile(xs)(x => x < 4)

//list length
val list = 1 to 100
list.length
list.foldRight(0)((_, acc) => acc + 1)
list.foldLeft(0)((acc, _) => acc + 1)

//list reverse
def reverse[A](list: List[A]): List[A] = list match {
  case Nil => list
  case x :: xs => reverse(xs) ++ List(x)
}
xs.reverse
reverse(xs)
xs.foldLeft(List[Int]())((acc, ys) => ys :: acc)

//list map
def map[A](list: List[A])(f: A => A): List[A] = list match {
  case Nil => list
  case x :: xs => f(x) :: map(xs)(f)
}
def map1[A](list: List[A])(f: A => A): List[A] =
  list.foldRight(List[A]())((ys, acc) => f(ys) :: acc)
map(xs)(_ + 1)
map1(xs)(_ + 1)

//list flatmap
def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] = {
  as.foldRight(List[B]())((ys, acc) => f(ys) ++ acc)
}
List(1, 2, 3).flatMap(i => List(i, i))
flatMap(List(1, 2, 3))(i => List(i, i))

//listfilter
def filter[A](as: List[A])(f: A => Boolean): List[A] = {
  as.foldRight(List[A]())((ys, acc) => if (f(ys)) ys :: acc else acc)
}
def filter1[A](as: List[A])(f: A => Boolean): List[A] = {
  flatMap(as)(ys => if (f(ys)) List(ys) else Nil)
}
xs.filter(_ > 3)
filter(xs)(_ > 3)
filter1(xs)(_ > 3)

//list zipWith
def zipWith[A, B, C](as: List[A], bs: List[B])(f: (A, B) => C): List[C] = (as, bs) match {
  case (_, Nil) => Nil
  case (Nil, _) => Nil
  case (a :: ax, b :: bx) => f(a, b) :: zipWith(ax, bx)(f)
}
(xs, xs).zipped.map(_ + _)
zipWith(xs, xs)(_ + _)

//whether a List contains another List as a subsequence
def hasSubsequence[A](list: List[A], sub: List[A]): Boolean = list match {
  case Nil => sub == Nil
  case _ if startsWith(list, sub) => true
  case _ :: ls => hasSubsequence(ls, sub)
}
def startsWith[A](list: List[A], sub: List[A]): Boolean = (list, sub) match {
  case (_, Nil) => true
  case (a :: ax, b :: bx) if a == b => startsWith(ax, bx)
  case _ => false
}
hasSubsequence(xs, List(1, 2))
hasSubsequence(xs, List(2, 2))
hasSubsequence(xs, List(2, 3))
hasSubsequence(xs, List(4))






