def values(fun: (Int) => Int, low: Int, high: Int) = {
  var list: List[(Int, Int)] = List()
  for (e <- low to high) {
    list = list:+((e, fun(e)))
  }
  list
}

values(x => x * x, -5, 5)

def max (one: Int)(two: Int) = if (one < two) two else one
(1 to 3).reduceLeft(_ max _)
var l = List(4, 8, 3, 4, 1, 8, 2)
l.reduceLeft(_ max _)

def fact (n: Int) = if (n == 0) 1 else (1 to n).reduceLeft(_ * _)
def fact0 (n: Int) = if (n < 0) -1 else if (n == 0) 1 else (1 to n).product
fact(0)
fact(1)
fact(2)
fact(3)
fact(7)
fact0(7)
fact0(-2)