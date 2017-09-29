def sum(f:Int => Int)(a:Int, b:Int): Int = {
  if(a > b) 0
  else f(a) + sum(f)(a + 1, b)
}
sum(x => x * x * x)(1, 5)
sum(x => x * x)(1, 5)
sum(x => x * x)(3, 5)

def sumTail(f:Int => Int)(a:Int, b:Int): Int = {
  def loop(a:Int, acc:Int): Int = {
    if(a > b) acc
    else loop(a + 1, f(a) + acc)
  }
  loop(a, 0)
}
sumTail(x => x * x * x)(1, 5)
sumTail(x => x * x)(1, 5)
sumTail(x => x * x)(3, 5)

def a(a:Int, b:Int) = sumTail(x => x * x)(a, b)
