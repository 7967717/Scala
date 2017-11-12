def isSorted[A](arr: Array[A], ordered: (A,A) => Boolean): Boolean = {
  def go(n: Int): Boolean = {
    if(arr.isEmpty || arr.length == 1) true
    else if(n == arr.length - 1) true
    else if(ordered(arr(n), arr(n + 1))) go(n + 1) else false
  }
  go(0)
}

val ints = Array(9, 3, 9, 3, 9, 7, 9)
val strs = Array("one", "two", "three", "four", "five")

isSorted(Array(), (a: Int, b: Int) => a <= b)
isSorted(Array(1), (a: Int, b: Int) => a <= b)
isSorted(ints, (a: Int, b: Int) => a <= b)
isSorted(ints.sorted, (a: Int, b: Int) => a <= b)
isSorted(strs, (a: String, b: String) => a <= b)
isSorted(strs.sorted, (a: String, b: String) => a <= b)