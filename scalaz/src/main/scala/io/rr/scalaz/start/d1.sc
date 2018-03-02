import scalaz._
import Scalaz._

1 != 2 && false
// doesn't work
//1 /== 2 && false
1 =/= 2 && false

1 > 2.0
1.0 ?|? 2.0
1.0 ?|? 1.0
2.0 ?|? 1.0
1.0 max 2.0
2.0 max 1.0

3
"3"
3.show
3.shows
3.println

'a' to 'e'
'a' |-> 'e'
3 |=> 5
'B'.succ
'Z'.succ
'A'.pred
1.succ


case class TrafficLight(name: String)
val red = TrafficLight("red")
val yellow = TrafficLight("yellow")
val green = TrafficLight("green")
implicit val TrafficLightEqual: Equal[TrafficLight] = Equal.equal(_ == _)
red === yellow
red === red


trait CanTruthy[A] {
  self =>
  /** @return true, if `a` is truthy. */
  def truthys(a: A): Boolean
}
object CanTruthy {
  def apply[A](implicit ev: CanTruthy[A]): CanTruthy[A] = ev
  def truthys[A](f: A => Boolean): CanTruthy[A] = new CanTruthy[A] {
    def truthys(a: A): Boolean = f(a)
  }
}
trait CanTruthyOps[A] {
  def self: A
  implicit def F: CanTruthy[A]
  final def truthy: Boolean = F.truthys(self)
}
object ToCanIsTruthyOps {
  implicit def toCanIsTruthyOps[A](v: A)(implicit ev: CanTruthy[A]) =
    new CanTruthyOps[A] {
      def self = v
      implicit def F: CanTruthy[A] = ev
    }
}

import ToCanIsTruthyOps._
implicit val intCanTruthy: CanTruthy[Int] = CanTruthy.truthys({
  case 0 => false
  case _ => true
})
10.truthy

implicit def listCanTruthy[A]: CanTruthy[List[A]] = CanTruthy.truthys({
  case Nil => false
  case _   => true
})
implicit val nilCanTruthy: CanTruthy[scala.collection.immutable.Nil.type] =
  CanTruthy.truthys(_ => false)
List("foo").truthy
Nil.truthy

