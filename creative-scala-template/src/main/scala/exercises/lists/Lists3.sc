def ones(n: Int): List[Int] =
  (0 until n).map(x => 1).toList
ones(3)

def descending(n: Int): List[Int] =
  (n until 0 by -1).toList.map(x => x)
descending(0)
descending(3)

def ascending(n: Int): List[Int] =
  (1 to n).toList.map(x => x)
ascending(0)
ascending(1)
ascending(3)

def double(list: List[Int] ): List[Int] =
  list map (x => x * 2)
double(List(1, 2, 3))
double(List(4, 9, 16))