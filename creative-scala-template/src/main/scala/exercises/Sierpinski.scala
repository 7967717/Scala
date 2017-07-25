package exercises

import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

/**
  * @author roman on 7/22/17.
  */
object Sierpinski {
  def main(args: Array[String]): Unit = {
    def sierpinski(count: Int): Image = {
      val triangle = Image.triangle(10, 10) lineColor Color.magenta
      count match {
        case 0 => triangle above (triangle beside triangle)
        case n =>
          val unit = sierpinski(n-1)
          unit above (unit beside unit)
      }
    }
    sierpinski(3).draw
  }

}
