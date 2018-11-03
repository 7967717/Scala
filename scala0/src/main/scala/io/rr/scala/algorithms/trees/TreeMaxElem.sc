trait Tree[+A]
case class Node[A](value:A, left:Tree[A], right:Tree[A]) extends Tree[A]
case object Empty extends Tree[Nothing]

def max(tree: Tree[Int]): Int = {
  def m(tree: Tree[Int], temp: Int): Int = tree match {
    case Empty => temp
    case Node(v, l, r) => {
      val max = temp.max(v)
      m(l, max).max(m(r, max))
    }
  }

  m(tree, Int.MinValue)
}

val value = Node[Int](1,
  Node(44,
    Node(7,
      Node(36, Empty, Empty),
      Node(9, Empty, Empty)),
    Empty),
  Node(27,
    Node(88,
      Empty,
      Node(13, Empty, Empty)),
    Node(2, Empty, Node(66, Empty, Empty))
  ))

max(value)


//
//trait Functor[F[_]] {
//
//  def map[A,B](x:F[A])(f: A => B):F[B]
//
//  def split[A,B](f:F[(A,B)]):(F[A], F[B]) =
//
//  def transform[A,B](e:Either[F[A], F[B]]):F[Either[A,B]] = ???