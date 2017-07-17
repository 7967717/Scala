val mul = (x: Int, y: Int) => x * y
val mulOneAtATime = (x: Int) => (y: Int) => x * y
mul(6, 7)
mulOneAtATime(6)(7)

def mulOneAtATime0(x: Int)(y: Int) = x * y

val a = Array("Hello", "World")
val b = Array("hello", "world")
a.corresponds(b)(_.equalsIgnoreCase(_))

def until(condition: => Boolean)(block: => Unit) {
  if (!condition) {
    block
    until(condition)(block)
  }
}

var x = 10
def condition = x == 0
def block = {
  x -= 1
  println(x)
}
until (condition) (block)

def indexOf(str: String, ch: Char): Int = {
  var i = 0
  until (i == str.length) {
    if (str(i) == ch) return i
    i += 1
  }
  return -1
}

indexOf("Hello", 'o')
indexOf("Hello", 'b')