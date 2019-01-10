abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def incl(x: Int): IntSet = NonEmpty(x, Empty, Empty)
  def contains(x: Int): Boolean = false
  override def union(other: IntSet): IntSet = other
  override def toString = "."
}

case class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int): IntSet = {
    if (x < elem) NonEmpty(elem, left.incl(x), right)
    else if (x > elem) NonEmpty(elem, left, right.incl(x))
    else this
  }
  def contains(x: Int): Boolean = {
    if (x < elem) left.contains(x)
    else if (x > elem) right.contains(x)
    else true
  }
  override def union(other: IntSet) = {
    left.union(right).union(other).incl(elem)
  }
  override def toString = s"{$left$elem$right}"
}

val set1 = NonEmpty(3, Empty, Empty).incl(5).incl(7).incl(9)
val set2 = NonEmpty(2, Empty, Empty).incl(4).incl(6).incl(8)
println(set1)
println(set2)
println(set2.union(set1))