//100%
def solution(a: Array[Int]): Int = {
  val max = 1000000000
  val res = a.foldLeft(Tuple2[Int, Int](0, 0)) {
    (tuple, elem) =>
      if (elem == 0)
        Tuple2(tuple._1 + 1, tuple._2)
      else {
        if (tuple._2 > max || tuple._2 == -1)
          Tuple2(tuple._1, -1)
        else
          Tuple2(tuple._1, tuple._2 + tuple._1)
      }
  }
  res._2
}