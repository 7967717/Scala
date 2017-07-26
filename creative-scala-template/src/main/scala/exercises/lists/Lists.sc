

def ones(x: Int): List[Int] = {
  def loop(x: Int, list: List[Int]): List[Int] = {
    x match {
      case 0 => Nil
      case 1 => list
      case _ => list ++ loop(x - 1, list)
    }
  }

  loop(x, List(1))
}
ones(3)
ones(1)
ones(0)

def ones1(n: Int): List[Int] =
  n match {
    case 0 => Nil
    case n => 1 :: ones1(n - 1)
  }
ones1(3)
ones1(1)
ones1(0)

def descending(n: Int): List[Int] =
  n match {
    case 0 => Nil
    case n => n :: descending(n - 1)
  }
descending(0)
descending(3)

def ascending(n: Int): List[Int] = {
  def loop(x: Int, counter: Int): List[Int] = {
    x match {
      case 0 => Nil
      case x => counter :: loop(x - 1, counter + 1)
    }
  }
  loop(n, 1)
}
ascending(0)
ascending(3)

def fill[A](n: Int, a: A) : List[A] = {
    n match {
      case 0 => Nil
      case x => a :: fill(n - 1, a)
    }
}

fill(3, "Hi")
