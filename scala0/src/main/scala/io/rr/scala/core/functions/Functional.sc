import scala.concurrent.Future

val pf: PartialFunction[Int, Unit] = {
  case i if i%2 == 0 => println("found even")
  case _:Int => println("found odd")
}
pf(1)
pf(2)

trait Publisher[T] {
  def subscribe(f: PartialFunction[T, Unit])
}

val publisher: Publisher[Int] = (f: PartialFunction[Int, Unit]) => f

val unit = publisher.subscribe(pf)


