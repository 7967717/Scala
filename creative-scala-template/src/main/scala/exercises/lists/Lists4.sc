def double[A](list: List[A] ): List[A] =
  list.flatMap(x => List(x, x))
double(List(1, 2, 3))
double(List("do", "ray", "me"))

def nothing[A](list: List[A] ): List[A] =
  list.flatMap(x => List())
nothing(List(1, 2, 3))
nothing(List("do", "ray", "me"))