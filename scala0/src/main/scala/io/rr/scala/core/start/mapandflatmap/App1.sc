
val o1 = Option(1)
val o2 = Option(2)

o1.map(x => o2.map(y => x + y))
o1.flatMap(x => o2.map(y => x + y))