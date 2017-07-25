package exercises

import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

/**
  * @author roman on 7/22/17.
  */
object Cross {

  def main(args: Array[String]): Unit = {
    def cross(count: Int): Image = {
      val unit = Image.circle(20)
      def loop(count: Int): Image = {
        count match {
          case 0 => unit
          case n => unit beside (unit above loop(n - 1) above unit) beside unit
        }
      }
      loop(count)
    }
    cross(3).draw
  }

}
