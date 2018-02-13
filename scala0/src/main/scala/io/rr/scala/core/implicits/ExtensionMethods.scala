package io.rr.scala.core.implicits

object ExtensionMethods extends AnyRef with App {
  implicit def richString(str: String) = {
    final class $anon extends scala.AnyRef {
      def awesomeMethod(): Unit =
        scala.Predef.println(s"awesomeMethod for $str")
    }
    new $anon()
  }
  ExtensionMethods.this.richString("My String").awesomeMethod()
}
