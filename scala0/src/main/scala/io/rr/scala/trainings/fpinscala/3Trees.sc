sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

def size[A](tree: Tree[A]): Int = tree match {
  case Leaf(_) => 1
  case Branch(left, right) => 1 + size(left) + size(right)
}

def maximum(tree: Tree[Int]): Int = tree match {
  case Leaf(n) => n
  case Branch(left, right) => maximum(left).max(maximum(right))
}

def depth[A](tree: Tree[A]): Int = tree match {
  case Leaf(_) => 0
  case Branch(l, r) => 1 + depth(l).max(depth(r))
}

def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = tree match {
  case Leaf(v) => Leaf(f(v))
  case Branch(l, r) => Branch(map(l)(f), map(r)(f))
}

def fold[A, B](tree: Tree[A])(f: A => B)(b: (B, B) => B): B = tree match {
  case Leaf(v) => f(v)
  case Branch(l, r) => b(fold(l)(f)(b), fold(r)(f)(b))
}

def size1[A](tree: Tree[A]): Int = {
  fold(tree)(n => 1)(1 + _ + _)
}

def maximum1(tree: Tree[Int]): Int = {
  fold(tree)(n => n)(_.max(_))
}

def depth1[A](tree: Tree[A]): Int = {
  fold(tree)(n => 0)((d1,d2) => 1 + d1.max(d2))
}

def map1[A, B](tree: Tree[A])(f: A => B): Tree[B] = {
  fold(tree)(n => Leaf(f(n)): Tree[B])(Branch(_,_))
}