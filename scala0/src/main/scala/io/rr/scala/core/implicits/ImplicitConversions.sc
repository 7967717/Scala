def toPrint(str: String) = print(str)
implicit def intToStr(int: Int) = int.toString
toPrint(1)

//is converted to
object ImplicitApp extends Object with App {
  def call(str: String): Unit = scala.Predef.println(str)
  def intToString(i: Int): String = i.toString
  call(intToString(1))
}