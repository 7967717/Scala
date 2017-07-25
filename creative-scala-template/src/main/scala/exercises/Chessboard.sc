import doodle.core.{Color, Image}

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

chessboard(1)

def chessboard1(count: Int): Image = {
  val blackSquare = Image.rectangle(30, 30) fillColor Color.black
  val redSquare = Image.rectangle(30, 30) fillColor Color.red
  val base = (redSquare beside blackSquare) above (blackSquare beside redSquare)

  def loop (count: Int) : Image = {
    count match {
      case 0 => base
      case n =>
        val unit = chessboard1(n - 1)
        (unit beside unit) above (unit beside unit)
    }
  }
  loop(count)
}

chessboard1(1)

chessboard(1) == chessboard(1)