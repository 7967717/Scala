val author = "Cay Horstmann"

val Name(first, last) = author

object Name {

  def unapply(input: String) = {
    val pos = input.indexOf(" ")
    if (pos == -1) None
    else Some((input.substring(0, pos), input.substring(pos + 1)))
  }

}

//case class Currency(value: Double, unit: String)
//Currency(29.95, "EUR")
//case Currency(amount, "USD") => println(s"$$$amount")

//case class Name0(first: String, last: String)
//
//Name0("Cay", "Horstmann")
//
//case Name0(first, last) => println(x.)