package io.rr.scala.core.fpinscala

/**
  * @author rrudenko on 15.11.2017.
  */
object ToTest {
  def main(args: Array[String]): Unit = {
    val list = 1 to 100000000
    println(list.length)
    println(list.foldRight(0)((x, acc) => acc + 1))
    println(list.foldLeft(0)((acc, x) => acc + 1))
  }
}
