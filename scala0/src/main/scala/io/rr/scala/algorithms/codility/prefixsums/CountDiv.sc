def solution(a: Int, b: Int, k: Int): Int = {
  //50%
//  def loop (first: Int, last: Int, k: Int, acc: Int) : Int = {
//      if(first > last) acc
//    else if (first % k == 0) loop(first + 1, last, k, acc + 1)
//    else loop(first + 1, last, k, acc)
//  }
//  loop(a, b, k, 0)

  //100%
  var res = b / k - a / k
  println(res)
  if (a % k == 0) res += 1
  res
}

solution(6, 11, 2)//3
solution(0, 1, 11)//1
solution(0, 11, 1)//12