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

}