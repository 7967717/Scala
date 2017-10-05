trait Generator[+T] {
  self =>
  def generate: T

  def map[S](f: T => S): Generator[S] = new Generator[S] {
    def generate: S = f(self.generate)
  }

  def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
    def generate: S = f(self.generate).generate
  }
}

val integers = new Generator[Int] {
  val rand = new java.util.Random
  override def generate: Int = rand.nextInt()
}
integers.generate

val booleans =
//  new Generator[Boolean] {
//  override def generate: Boolean = integers.generate > 0
//}
  for (x <- integers) yield x > 0
//  integers.map(x => x > 0) //the same as above
booleans.generate
booleans.generate

//val pairs =
//  new Generator[(Int, Int)] {
//  override def generate: (Int, Int) = (integers.generate, integers.generate)
//}
def pairs[T, U](t: Generator[T], u: Generator[U]) =
//for (x <- t; y <- u) yield (x, y)
  t.flatMap(x => u.map(y => (x, y))) //the same as above
pairs(integers, integers).generate

def single[T](x: T): Generator[T] = new Generator[T] {
  override def generate: T = x
}
single(1).generate

def lists: Generator[List[Int]] = for {
  isEmpty <- booleans
  list <- if (isEmpty) emptyLists else nonEmptyLists
} yield list
def emptyLists = single(Nil)
def nonEmptyLists = for {
  head <- integers
  tail <- lists
} yield head :: tail
lists.generate

trait Tree
case class Inner(left: Tree, right: Tree) extends Tree
case class Leaf(x: Int) extends Tree

def leafs: Generator[Leaf] = integers.map(x => Leaf(x))
def inners: Generator[Inner] =
//  for {l <- trees; r <- trees} yield Inner(l, r)
  trees.flatMap(l => trees.map(r => Inner(l, r))) //the same as above
def trees: Generator[Tree] =
  for {isLeaf <- booleans; tree <- if (isLeaf) leafs else inners} yield tree
trees.generate