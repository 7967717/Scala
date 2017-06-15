import java.text.MessageFormat

val x0 = 0

if (x0 > 0) {
  1
}
else if (x0 == 0) 0 else -1

val s = "Hello"
for (i <- 0 to s.length - 1)
  print(i)
for (ch <- "Hello")
  print(ch)

for (i <- 1 to 3; j <- 1 to 3) print(f"${10 * i + j}%2d")
for (i <- 1 to 3; j <- 1 to 3) print(f"${10 * i + j}%3d")
for (i <- 1 to 3; j <- 1 to 3) print(f"${10 * i + j}%4d")

for (i <- 1 to 3; j <- 1 to 3 if i != j) print(f"${10 * i + j}%3d")

for (i <- 1 to 3; from = 4 - i; j <- from to 3) print(f"${10 * i + j}%3d")

for (i <- 1 to 10) yield i % 3

for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar

def abs(x: Double) = if (x >= 0) x else -x

def fac(n: Int): Int = if (n <= 0) 1 else n * fac(n - 1)

def decorate(str: String, left: String = "[", right: String = "]") =
  left + str + right

decorate("Hello")
decorate("Hello", "<<<")
decorate(right = ">>>", str = "Hello")
decorate(left = "<<<", str = "Hello", right = ">>>")

def sum(args: Int*) = {
  var result = 0
  for (arg <- args) result += arg
  result
}
val s0 = sum(1, 4, 9, 16, 25)
//val s = sum(1 to 5) // Error
val s1 = sum(1 to 5: _*) //ok

def recursiveSum(args: Int*): Int = {
  if (args.isEmpty) 0
  else args.head + recursiveSum(args.tail: _*)
}

val str = MessageFormat.format("The answer to {0} is {1}",
  "everything", 42.asInstanceOf[AnyRef])

def box(s: String): Unit = {

  val border = "-" * (s.length + 2)

  print(f"$border%n|$s|%n$border%n")
}
box("Hello")

{}

var i = 10
while (i >= 0) {
  System.out.println(i)
  i -= 1
}

def countdown(n: Int) {
  var i = n
  while (i >= 0) {
    System.out.println(i)
    i -= 1
  }
}
countdown(5)