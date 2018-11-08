
def swap(a: (Int, Int)) = a match {
  case (x, y) => (y, x)
}
swap(1, 2)

def swap1(a: Array[Int]) = a match {
  case Array(x, y, z@_*) => Array(y, x) ++ z
  case _ => a
}

swap1(Array(1, 2, 3))
swap1(Array(1, 2, 3, 4))
swap1(Array(1))

abstract class Item
case class Article(desc: String, price: Double) extends Item
case class Bundle(desc: String, disc: Double, items: Item*) extends Item

val book = Article("Scala", 39.95)
val bottle = Article("Old", 79.95)
val gift = Bundle("Gift", 10, book, bottle)
def price(it: Item): Double = it match {
  case Article(_, price) => price
  case Bundle(_, disc, items @ _*) => items.map(price).sum - disc
}
price(book)
price(gift)

abstract class OptionDouble {
  def isEmpty: Boolean
  def get: Double
}
case class SomeDouble (value: Double) extends OptionDouble {
  override def isEmpty = false
  override def get = value
}
case class NoneDouble() extends OptionDouble {
  override def isEmpty = true
  override def get = throw new NoSuchElementException
}

def inv(x: Double):OptionDouble = x match {
  case 0 => NoneDouble()
  case _ => SomeDouble(1 / x)
}
inv(5)
inv(0)

import scala.math._
def f(x: Double) = {
  if (x <= 1) SomeDouble(sqrt(1 - x)) else NoneDouble()
}
def compose(a: Double => OptionDouble, b: Double => OptionDouble) = {
  (x: Double) => b(x) match {
      case SomeDouble(res) => a(res)
      case NoneDouble() => NoneDouble()
    }
}

val h = compose(f, inv)

h(0)
h(1)
h(2)
h(0.5)