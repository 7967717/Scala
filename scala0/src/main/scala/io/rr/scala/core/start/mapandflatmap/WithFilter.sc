val o = Some("str")
//val o = None

val s = Set("a", "b", "str")
//val s = Set("a", "b", "st")

def pr(s: String): Unit = {
  println(s"Printing '$s'")
}

for {
  x <- o
  if s.contains(x)
} yield pr(x)