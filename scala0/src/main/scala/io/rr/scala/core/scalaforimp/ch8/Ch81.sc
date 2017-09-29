def printAny(x: Any) {
  println(x)
}
def printUnit(x: Unit) {
  println(x)
}

printAny("Hello")
printUnit("Hello")

def show(o: Any) {
  println(s"${o.getClass}: $o")
}
show(3)
show(3, 4, 5)

class Item(val description: String, val price: Double) {

  final override def equals(other: Any) = other match {
    case that: Item => description == that.description && price == that.price
    case _ => false
  }

  final override def hashCode = (description, price).##
}

val i0 = new Item("item", 10)
val i1 = new Item("item", 10)
i0.equals(i1)
i0.eq(i1)
i0 == i1