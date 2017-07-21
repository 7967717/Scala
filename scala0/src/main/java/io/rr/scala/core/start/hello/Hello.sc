val s: String = "hello"
val c: Char = s.last
val cap: String = s.capitalize

def f0(x: Int, y: Int) = x * x + y * y
f0(2, 3)

def f1(x: Int, y: Int) = {
  def sqr(z: Int) = z * z
  sqr(x) + sqr(y)
}
f1(2, 3)





