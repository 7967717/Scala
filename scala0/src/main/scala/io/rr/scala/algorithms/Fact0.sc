def fact(n: Int): Int = {
  def loop(n: Int, accum: Int): Int = {
    n match {
      case i if i <= 0 => accum
      case _ => loop(n - 1, accum * n)
    }
  }
  loop(n, 1)
}

fact(0)
fact(1)
fact(2)
fact(3)

def fact0(n: Int): Int = {
  def loop(n: Int, accum: Int): Int = {
    if(n == 0) accum else loop(n - 1, accum * n)
  }
  loop(n, 1)
}

fact0(0)
fact0(1)
fact0(2)
fact0(3)
fact0(4)