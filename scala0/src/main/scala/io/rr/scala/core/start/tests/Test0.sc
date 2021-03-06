import scala.concurrent.Future

val a = "Test"
val b = new String("Test")
a == b
a.equals(b)

val f :: s :: Nil = List(1, 2)
val List(fs, sn) = List(1, 2)

Some(1).flatMap(x => Some(x))

val f1: (AnyRef => Int) = x => x.hashCode()
val g: (String => Int) = f1
g("abc")
"abc".hashCode

val l = List(1, 2, 3)
l.head :: Nil
l.head :: 2 :: 3 :: Nil
l.head :: (2 :: Nil)
l.head :: (2 :: Nil) :: Nil
l.head :: (2 :: Nil :: Nil :: Nil) :: Nil
l.head

"1".toInt