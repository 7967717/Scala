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