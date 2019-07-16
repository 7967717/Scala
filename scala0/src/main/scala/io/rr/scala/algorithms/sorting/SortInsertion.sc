//O(n * n)
def insert(x: Int, list: List[Int]): List[Int] = list match {
  case Nil => List(x)
  case h :: t => if (x <= h) x :: list else h :: insert(x, t)
}

def isort(list: List[Int]): List[Int] = list match {
  case Nil => List()
  case h :: t => insert(h, isort(t))
}

isort(List(2, 1, 4, 3))
isort(List(2, 1))
isort(List(2))
isort(List())