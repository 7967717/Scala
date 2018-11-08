abstract class Stack[A] {
  def push(x: A): Stack[A] = new NonEmptyStack(x, this)
  def isEmpty: Boolean
  def top: A
  def pop: Stack[A]
}
class EmptyStack[A] extends Stack[A] {
  def isEmpty = true
  def top = throw new Error("EmptyStack.top")
  def pop = throw new Error("EmptyStack.pop")
}
class NonEmptyStack[A](elem: A, rest: Stack[A]) extends Stack[A] {
  def isEmpty = false
  def top = elem
  def pop = rest
}

val x = new EmptyStack[Int]
val y = x.push(1).push(2)
println(y.top)
println(y.pop.top)


def isPrefix[A](p: Stack[A], s: Stack[A]): Boolean = {
  p.isEmpty ||
    p.top == s.top && isPrefix[A](p.pop, s.pop)
}

val s1 = new EmptyStack[String].push("abc")
val s2 = new EmptyStack[String].push("abx").push(s1.top)
println(isPrefix(s1, s2))
