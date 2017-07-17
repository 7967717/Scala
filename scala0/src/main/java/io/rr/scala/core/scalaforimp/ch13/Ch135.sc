for (i <- (0 until 100000).par) print(s" $i")
(for (i <- (0 until 100000).par) yield i) == (0 until 100000)

var coll = 0 until 100000
coll.par.foreach(i => print(s" $i"))
val result = coll.par.filter(_ % 2 == 0).seq




