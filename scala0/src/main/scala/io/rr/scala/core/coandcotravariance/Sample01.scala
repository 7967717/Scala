package io.rr.scala.core.coandcotravariance

class Sample01 {

  case class InvariantContainer[A]()
  case class CovariantContainer[+A]()
  case class ContravariantContainer[-A]()

  class Car
  class Subaru extends Car

  // works
  val inv1: InvariantContainer[Subaru] = InvariantContainer[Subaru]
  val inv2: InvariantContainer[Car] = InvariantContainer[Car]
  // doesn't work
//  val inv3: InvariantContainer[Subaru] = InvariantContainer[Car]
//  val inv3: InvariantContainer[Car] = InvariantContainer[Subaru]

  // works
  val cov1: CovariantContainer[Subaru] = CovariantContainer[Subaru]
  val cov2: CovariantContainer[Car] = CovariantContainer[Car]
  val cov3: CovariantContainer[Car] = CovariantContainer[Subaru]
  // doesn't work
//  val inv4: InvariantContainer[Subaru] = InvariantContainer[Car]

  // works
  val con1: ContravariantContainer[Subaru] = ContravariantContainer[Subaru]
  val con2: ContravariantContainer[Subaru] = ContravariantContainer[Car]
  val con3: ContravariantContainer[Subaru] = ContravariantContainer[Car]
  // doesn't work
//  val con4: ContravariantContainer[Car] = ContravariantContainer[Subaru]



}
