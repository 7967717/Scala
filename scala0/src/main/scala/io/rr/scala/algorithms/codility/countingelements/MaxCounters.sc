
def solution(n: Int, a: Array[Int]): Array[Int] = {
  val counters = new Array[Int](n)

  var max = 0
  var maxCounter = 0
  for (count <- a) {
    if (count != n + 1) {

      if (counters(count - 1) < maxCounter) {
        counters(count - 1) = maxCounter
      }
      counters(count - 1) += 1
      max = max.max(counters(count - 1))
      println("count " + count + " " + max)
    } else {
      println("final " + max)
      maxCounter = max
    }
  }

  for (ind <- counters.indices) {
    if (counters(ind) < maxCounter) {
      counters(ind) = maxCounter
    }
  }

  counters
}

solution(5, Array(3, 4, 4, 6, 1, 4, 4))
