

class Complex(val real: Double, val imaginary: Double = 0.0) {
  def + (rhs: Complex): Complex = new Complex(real + rhs.real, imaginary + rhs.imaginary)
  //      def +[N : Numeric](n: N) = new Complex(implicitly[Numeric[N]].plus(real, n))
}


// implicit defs

val c = new Complex(1.0)

implicit def int2Complex(i: Int): Complex = new Complex(i)

// Conversions to an expected type
val i: Complex = 1

def foo(c: Complex) = println(c.real)

foo(2)

// Conversions of the receiver of a selection
println(2.imaginary)
println((2 + i).real)

// Implicit parameters
def bar(s: Int)(implicit convertor: Int => Complex): Complex = convertor(s)

bar(123)(int2Complex)

val some: Option[String] = Some("Alex")
val none: Option[String] = None

println(some.isDefined)
println(none.isEmpty)

// Side effects
println("------- foreach -------")
println(some.foreach(r => println(r)))
println(none.foreach(r => println(r)))

// Map
println("------- map -------")
println(some.map(r => r.length))
println(none.map(r => r.length))

// flatMap
println("------- flatMap -------")
def getSurname(name: String): Option[String] = if (name == "Martin") Some("Odersky") else None

println(Some("Martin").map(getSurname))

println(Some("Martin").flatMap(getSurname))

println(some.flatMap(getSurname))

println(none.flatMap(getSurname))

// Filter
println("------- filter -------")
println(some.filter(_ == "Alex"))
println(some.filter(_ != "Alex"))
println(none.filter(_ != "Alex"))

println("------- toList -------")
println(some.toList)

println("------- get, orElse & getOrElse -------")
println(some.get)
println(none.getOrElse("Martin"))
println(none.orElse(some))

println("------- Java and NPE -------")
println(Option("asdf"))