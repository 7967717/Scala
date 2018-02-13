implicit class RichString(str: String) {
  def awesomeMethod1(): Unit =
    println(s"awesomeMethod1 for $str")
}
"My String".awesomeMethod1()

implicit def richString(str: String) = new {
  def awesomeMethod2(): Unit =
    println(s"awesomeMethod2 for $str")
}
"My String".awesomeMethod2()

//is converted to
object MethodExtension extends AnyRef with App {
  implicit def richString(str: String) = {
    final class $anon extends scala.AnyRef {
      def awesomeMethod(): Unit =
        scala.Predef.println(s"awesomeMethod2 for $str")
    }
    new $anon()
  }
  MethodExtension.this.richString("My String").awesomeMethod()
}
