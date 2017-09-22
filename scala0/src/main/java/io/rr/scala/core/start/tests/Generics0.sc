class Fruit
case class Apple() extends Fruit
case class Banana() extends Fruit

def pass(a: Fruit): Fruit = {
  a
}

val f = new Fruit
val a = Apple()
val b = Banana()

pass(f)
pass(a)
pass(b)

val arrf: Array[Fruit] = Array(Apple())
val arra: Array[Apple] = Array(Apple())
//val arr: Array[Fruit] = arra
