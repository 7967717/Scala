def sum0(f: Int => Int, a: Int, b: Int) = {
  def loop(a: Int, acc: Int): Int = {
    if(a > b) acc
    else loop(a + 1, f(a) + acc)
  }
  loop(a, 0)
}
sum0(x => x * x, 3, 5)

def sum(f: Int => Int, a: Int, b: Int): Int = {
  if(a > b) 0
  else f(a) + sum(f, a + 1, b)
}
sum(x => x * x, 3, 5)

def product(f: Int => Int)(a: Int, b: Int): Int = {
    if(a > b) 1
    else f(a) * product(f)(a + 1, b)
}
product(x => x * x)(3, 4)

def fact(x: Int): Int = {
  product(x => x)(1, x)
}
fact(5)

def mapReduce(f: Int => Int, comp: (Int, Int) => Int, z: Int)(a: Int, b: Int): Int = {
  if(a > b) z
  else comp(f(a), mapReduce(f, comp, z)(a + 1, b))
}
mapReduce(x => x * x, (x, y) => x + y, 0)(3, 5)