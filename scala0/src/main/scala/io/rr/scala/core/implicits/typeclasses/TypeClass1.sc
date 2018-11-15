trait CanGreet[T] {
  def sayHi(t: T): String
}
object CanGreet {
  def apply[T](implicit C: CanGreet[T]): CanGreet[T] = C
}

case class Player(nickname: String, var age: Int)

object Player {
  implicit val playerGreeter: CanGreet[Player] = new CanGreet[Player] {
    def sayHi(t: Player): String = s"Hi, I'm player ${t.nickname}, I'm ${t.age}!"
  }
}

def greet[T: CanGreet](t: T): String = {
//  val greeter = implicitly[CanGreet[T]]
  CanGreet[T].sayHi(t)
}

greet(Player("John", 37))