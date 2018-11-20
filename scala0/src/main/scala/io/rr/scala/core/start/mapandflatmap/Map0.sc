val l1 = 1 to 3
val l2 = 4 to 6
val l3 = 7 to 9

val ls = List(l1, l2, l3)
ls.map(_.toList).map(x => x.map(y => if (y > 5) y + "$"))
ls.flatMap(_.toList)

