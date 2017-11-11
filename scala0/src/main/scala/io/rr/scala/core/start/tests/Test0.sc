val a = "Test"
val b = new String("Test")
a == b
a.equals(b)

val f :: s :: Nil = List(1, 2)
val List(fs, sn) = List(1, 2)

Some(1).flatMap(x => Some(x))