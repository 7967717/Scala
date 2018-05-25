package io.rr.intro.reactive

import akka.actor.{ActorRef, ActorSystem}
import akka.stream._
import akka.stream.scaladsl.{Source, Zip}
import akka.util.Timeout


object App01 extends App{
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer.create(system)
//  implicit val timeout = Timeout(5.seconds)
  implicit val ec = system.dispatcher

//  1
  Source(1 to 5).runForeach(println)

//  2
//  private val nmb = Source(1 to 3)
//  private val str = Source(List("a", "b", "c"))
//  private val composite: Any = Source() { implicit b =>
//    val zip = b.add(Zip[Int, String]())
//    nmb ~> zip.in0
//    str ~> zip.in1
//    zip.out
//  }
//  composite.runForeach(println)

//  3
//  private val fast = Source(() => Iterator from 0)
//  fast.map(x => {Thread.sleep(1000); x}).runForeach(println)



}
