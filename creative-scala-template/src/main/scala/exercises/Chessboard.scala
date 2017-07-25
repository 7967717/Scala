package exercises

import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

/**
  * @author roman on 7/22/17.
  */
object Chessboard {
  def main(args: Array[String]): Unit = {

    chessboard(1).draw
  }

  def chessboard(count: Int): Image = {
    val blackSquare = Image.rectangle(30, 30) fillColor Color.black
    val redSquare = Image.rectangle(30, 30) fillColor Color.red

    val base =
      (redSquare beside blackSquare) above (blackSquare beside redSquare)
    count match {
      case 0 => base
      case n =>
        val unit = chessboard(n - 1)
        (unit beside unit) above (unit beside unit)
    }
  }
}
