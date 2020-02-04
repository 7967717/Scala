val list = List(1)
val f = (x: Int) => x + 1
val g = (x: Int) => List(x)
f(1)
g(1)
list.map(f) == list.flatMap(x => List(f(x)))
list.flatMap(x => List(x))

list.flatMap(g)
List(1).flatMap(g) == g(1)
list.flatMap(g) == list

Some(1).flatMap(x => Some(x + 1))
Some(1).flatMap(x => Some(x))
Some(1).map(x => Some(x))
Some(1).map(x => Some(x)).flatten

