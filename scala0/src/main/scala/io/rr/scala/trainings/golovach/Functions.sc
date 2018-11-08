val f: Int => String = {
  case 1 => "one"
  case 2 => "two"
  case 3 => "three"
}

f(1)
// the same
val g: PartialFunction[Int, String] = {
  case 1 => "one"
  case 2 => "two"
  case 3 => "three"
}
g.apply(1)