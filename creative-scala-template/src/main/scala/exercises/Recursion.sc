def identity(n: Int): Int =
  n match {
    case 0 => 0
    case n => 1 + identity(n-1)
  }
identity(0)
identity(1)
identity(3)

def double(n: Int): Int =
  n match {
    case 0 => 0
    case n => 2 * n
  }
double(0)
double(1)
double(3)

def double1(n: Int): Int =
  n match {
    case 0 => 0
    case n => 2 + double1(n-1)
  }
double1(0)
double1(1)
double1(3)
double1(4)
double1(5)

