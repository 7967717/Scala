import scala.collection.immutable.HashMap

def foo(n: Double, d: HashMap[String, Double]) = {
  val newD = d map {
    case (key, value) => (key, (value - n).abs * n)
  }
//  newD
  newD.maxBy(_._2)._1
}

val d = HashMap("r" -> 0.1, "g" -> 0.3, "b" -> 0.6)
foo(0.0, d)
foo(0.1, d)
foo(0.2, d)
foo(0.3, d)
foo(0.4, d)
foo(0.5, d)
foo(0.6, d)
foo(0.7, d)
foo(0.8, d)
foo(0.9, d)
foo(1.0, d)
