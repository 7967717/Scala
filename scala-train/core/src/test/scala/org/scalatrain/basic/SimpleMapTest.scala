package org.scalatrain.basic

import org.scalatest._
import org.scalatrain.basic.task.SimpleMap

class SimpleMapTest extends FunSuite with Matchers {

  test("An empty Map should have size 0") {
    val sm = new SimpleMap[String, String]
    sm.size should be(0)
  }

  test("Update should put a value to SimpleMap") {
    val sm = new SimpleMap[String, String]
    sm("key") = "value"
    assert(sm.size == 1)
  }

  test("Apply should return value or null") {
    val sm = new SimpleMap[String, String]
    sm("key") = "value"
    sm("key") should be("value")
    sm("don't exist") should be(null)
    assert(sm.size == 1)
  }

  test("-= should remove key from SimpleMap") {
    val sm = new SimpleMap[String, String]
    sm("key") = "value"
    sm -= "key"
        sm("don't exist") should be(null)
    assert(sm.size == 0)
  }

  test("SimpleMap should be a function") {
    val sm = new SimpleMap[String, String]
    sm("key") = "value"
    def hof(f: String => String) = f("key")
    hof(sm) should be ("value")
  }

  test("Variance") {
    val mapping = 1.to(10).map(i => i -> i).foldLeft(new SimpleMap[Int, Int]) {
      case (sm, (k, v)) =>
        sm(k) = v
        sm
    }
    println(mapping)

    val mapping1 = SimpleMap((1 to 20).map(i => i -> i) : _*) //the same as above
    println(mapping1)

    val mapping2 = SimpleMap(1 -> "one", 22 -> "twenty two")
    val mapping22 = mapping2.map { case (key, value) =>
      val newValue = value.split("\\s+").map(_.length)
      (key, newValue)
    }
    println(mapping2)
    println(mapping22)
  }

}
