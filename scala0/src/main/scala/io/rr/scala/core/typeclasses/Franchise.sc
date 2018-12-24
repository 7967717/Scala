class Franchise(name: String) {
  case class Character(name: String)
  def createFanFictionWith(lovestruck: Character,
                            objectOfDesire: Character): (Character, Character) =
    (lovestruck, objectOfDesire)
}

val starTrek = new Franchise("Star Trek")
val starWars = new Franchise("Star Wars")

val quark = starTrek.Character("Quark")
val jadzia = starTrek.Character("Jadzia Dax")

val luke = starWars.Character("Luke Skywalker")
val yoda = starWars.Character("Yoda")

//starTrek.createFanFictionWith(lovestruck = quark, objectOfDesire = luke) // does not compile
starTrek.createFanFictionWith(lovestruck = quark, objectOfDesire = jadzia)

class A {
  class B
  var b: Option[B] = None
}
val a1 = new A
val a2 = new A
val b1 = new a1.B
val b2 = new a2.B
a1.b = Some(b1)
//a2.b = Some(b1) // does not compile

