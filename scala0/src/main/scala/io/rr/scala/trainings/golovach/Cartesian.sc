val i = Set(1, 2, 3)
val s = Set("A", "B", "C")

def cart0[A, B](s0: Set[A], s1: Set[B]) = {
  s0.flatMap(e0 => s1.map(e1 => (e0, e1)))
}
def cart1[A, B](s0: Set[A], s1: Set[B]) = {
  for(e0 <- s0; e1 <- s1) yield (e0, e1)
}

cart0(i, s)
cart1(i, s)
