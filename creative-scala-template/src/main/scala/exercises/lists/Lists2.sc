def increment(list: List[Int]): List[Int] =
  list match {
    case Nil => Nil
    case hd :: tl => (hd + 1) :: increment(tl)
  }
increment(List(1, 2, 3))

def increment1(list: List[Int]): List[Int] =
  list.map(x => x + 1)
increment1(List(1, 2, 3))

0 until 10
0.0 until 5.0
0 until 10 by 2
0.0 until 1.0 by 0.3

(0 until 3) map (x => x + 1)
(0 until 7).toList
(7 until 0 by -1).toList
(0 until 3).map(x => x + 1).toList

def fill[A](n: Int, a: A): List[A] =
  (0 until n).toList.map(x => a)
fill(3, "Hi")