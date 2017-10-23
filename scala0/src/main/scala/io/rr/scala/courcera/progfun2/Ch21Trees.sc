abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}

object Empty extends IntSet {
  def incl(x: Int): IntSet = NonEmpty(x, Empty, Empty)
  def contains(x: Int): Boolean = false
}

case class NonEmpty(elem: Int, left: IntSet, rigth: IntSet) extends IntSet {
  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left.incl(x), rigth)
    else if (x > elem) new NonEmpty(elem, left, rigth.incl(x))
    else this
  }
  def contains(x: Int): Boolean = {
    if (x < elem) left.contains(x)
    else if (x > elem) rigth.contains(x)
    else true
  }
}