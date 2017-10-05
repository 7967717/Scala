val list = List(1)
val f = (x: Int) => x
val g = (x: Int) => List(x)
f(1)
g(1)
list.map(f) == list.flatMap(x => List(f(x)))

list.flatMap(g)
List(1).flatMap(g) == g(1)
list.flatMap(g) == list
