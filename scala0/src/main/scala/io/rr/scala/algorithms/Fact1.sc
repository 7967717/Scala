def fact0(x: Long): Long = x match {
  case 0 => 1
  case 1 => 1
  case _ => x * fact0(x - 1)
}

def fact(x: Long): Long = {
  def loop(a: Long, b: Long): Long = {
    if (a < 1) 0
    else if (a == 1) b
    else loop(a - 1, a * b)
  }
  loop(x, 1)
}


fact0(10)
fact(10)