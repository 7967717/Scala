case class Greets[T]( private val name: T ) {
//case class Greets[+T]( private val name: T ) {
  def hello() { println("Hello " + name) }
  def getName: T = name
}

def sayHi1[T]( g: Greets[T] ) { g.hello() }
sayHi1(Greets("AAA"))
sayHi1(Greets("BBB"))
def sayHi2( g: Greets[_] ) { g.hello() }
sayHi2(Greets("CCC"))
sayHi2(Greets("DDD"))

val greets1: Greets[String] = Greets("John")
val greets2: Greets[Symbol] = Greets('Jack)
//val greetsList1: List[Greets[Any]] = List(greets1, greets2)
//val greetsList1: List[Greets[Any]] = List(greets1, greets2)
val greetsList2: List[Greets[_]] = List(greets1, greets2)
greetsList2.foreach(_.hello())