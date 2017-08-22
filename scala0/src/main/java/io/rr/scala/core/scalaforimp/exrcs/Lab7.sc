
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
