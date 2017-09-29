val s0 = Option("Hello")
val s1 = Option(null)

println(s0.isDefined)
println(s1.isDefined)

println(s0.get)
try {
  println(s1.get)
} catch {
  case e: Exception => println(e)
}
println(s1.getOrElse("no elem"))

val myMap = Map("a" -> 42, "b" -> 43)
myMap.get("a").map("Val " + _).getOrElse("No val")
myMap.get("a").getOrElse("No val")
myMap.getOrElse("a", "No val") //the same
myMap.getOrElse("c", "No val")
