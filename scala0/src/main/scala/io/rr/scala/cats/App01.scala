package io.rr.scala.cats

import cats.effect.IO

object App01 extends App {
  val program = IO {
    println("Welcome to Scala!  What's your name?")
    val name = Console.readLine
    println(s"Well hello, $name!")
  }

  program.unsafeRunSync()
  program.unsafeRunSync()
}
