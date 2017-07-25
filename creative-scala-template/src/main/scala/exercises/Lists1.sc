
def double(list: List[Int]): List[Int] = {
  list match {
    case Nil => Nil
    case hd :: tl => (hd * 2) :: double(tl)
  }
}
double(List(1, 2, 3))

def product(list: List[Int]): Int = {
  def loop(list: List[Int], accum: Int): Int = {
    list match {
      case Nil => accum
      case hd :: tl => loop(tl, accum * hd)
    }
  }

  loop(list, 1)
}
product(Nil)
product(List(1, 2, 3))

def product1(list: List[Int]): Int = {
  list match {
    case Nil => 1
    case hd :: tl => hd * product1(tl)
  }
}
product1(Nil)
product1(List(1, 2, 3))

def contains[A](list: List[A], elem: A): Boolean = {
  list match {
    case Nil => false
    case hd :: tl => (hd == elem) || contains(tl, elem)
  }
}
contains(List(1, 2, 3), 3)
contains(List("one", "two", "three"), "four")
contains(List("one", "two", "three"), "three")

def first[A](list: List[A], elem: A): A = {
  list match {
    case Nil => elem
    case hd :: tl => hd
  }
}
first(Nil, 4)
first(List(1, 2, 3), 4)

def reverse[A](list: List[A]): List[A] = {
  def loop(list: List[A], accum: List[A]): List[A] = {
    list match {
      case Nil => accum
      case hd :: tl => loop(tl, hd :: accum)
    }
  }

  loop(list, List())
}
reverse(List(1, 2, 3))
reverse(List("a", "b", "c"))