import java.util.concurrent.TimeUnit

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Success

val oneF = Future {
  TimeUnit.SECONDS.sleep(3)
  println("Hello from " + Thread.currentThread().getName)
  1
}
oneF.isCompleted
TimeUnit.SECONDS.sleep(4)
oneF.isCompleted
//oneF.onComplete{
//  println
//}

oneF.andThen {
  case Success(n) => println(n)
}.map(_ * 10).foreach(println)

