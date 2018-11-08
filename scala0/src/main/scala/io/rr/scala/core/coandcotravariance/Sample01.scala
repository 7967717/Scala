package io.rr.scala.core.coandcotravariance

object Sample01 extends App{

  sealed trait Container[A] {
    def accessor: A
    def mutator(a: A): Unit
  }

  case class InvariantContainer[A](var a: A) {
    def accessor(): A = {
      println(a);
      a
    }

    def mutator(a0: A): Unit = {
      println(a0)
      a = a0
    }
  }
//  CovariantContainer
  case class Producer[+A](a: A) {
    def produce(): A = {
      println(a)
      a
    }
//    def mutator(a0: A): Unit = {
//      a = a0
//    }
  }
//  ContravariantContainer
  case class Consumer[-A]() {
//    def accessor():A = a
    def consume(a0: A): Unit = {
      println(a0)
    }
  }

  class Car()
  class Subaru() extends Car

  // works
  val inv: InvariantContainer[Subaru] = InvariantContainer[Subaru](new Subaru())
  private val subaru: Subaru = inv.accessor()
  inv.mutator(new Subaru())
  // doesn't work
//  val inv3: InvariantContainer[Subaru] = InvariantContainer[Car]
//  val inv3: InvariantContainer[Car] = InvariantContainer[Subaru]

  // works
  val cov: Producer[Car] = Producer[Subaru](new Subaru())
  private val car1: Car = cov.produce()
  // doesn't work
//  val inv4: InvariantContainer[Subaru] = InvariantContainer[Car]

  // works
  val con: Consumer[Subaru] = Consumer[Car]()
  con.consume(new Subaru())
  // doesn't work
//  val con4: ContravariantContainer[Car] = ContravariantContainer[Subaru]



}
