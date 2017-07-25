package exercises

import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

/**
  * @author rrudenko on 25.07.2017.
  */
object Rose {
  def main(args: Array[String]): Unit = {
    // Parametric equation for rose with k = 7
    def rose(angle: Angle) =
      Point.polar((angle * 7).cos * 200, angle)
    (rose _)(0.degrees)
    rose(0.degrees)
  }

}
