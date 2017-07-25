1 + 2
1.+(2) //the same

"Hello" + "World"
"Hello" ++ "World"
"Hello".++("World")

object Example {
  val hi = "Hi!"
}
Example.hi

object Example1 {
  val hi = "Hi!"

  object Example2 {
    val hello = "Hello!"
  }
}
Example1.hi
Example1.Example2.hello

val b = 1
val a = b - 1
//val b = 1

val answer = a + b
println(answer)
