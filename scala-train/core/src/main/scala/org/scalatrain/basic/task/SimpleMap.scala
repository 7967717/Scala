package org.scalatrain.basic.task

object SimpleMap {
  def apply(args: (String, String)*): SimpleMap = {
    val result = new SimpleMap
    args.foreach{case (k, v) => result(k) = v }
    result
  }
}

class SimpleMap extends Function1[String, String]{

  val javaMap = new java.util.HashMap[String, String]()

  def update(k: String, v: String): String = javaMap.put(k, v)
  def apply(k: String): String = javaMap.get(k)
  def -=(k: String): String = javaMap.remove(k)
  def f(m: SimpleMap => SimpleMap): SimpleMap = new SimpleMap

  def size: Int = javaMap.size()

  def filterKey(p: String => Boolean): SimpleMap = {
    val result = new SimpleMap
    val iterator = javaMap.entrySet().iterator()
    while (iterator.hasNext) {
      val next = iterator.next()
      if (p(next.getKey)) {
        result(next.getKey) = next.getValue
      }
    }
    result
  }

  def filter(p: ((String, String)) => Boolean): SimpleMap = {
    val result = new SimpleMap
    val iterator = javaMap.entrySet().iterator()
    while (iterator.hasNext) {
      val next = iterator.next()
//      if (p((next.getKey, next.getValue))) {
      if (p(next.getKey -> next.getValue)) {
        result(next.getKey) = next.getValue
      }
    }
    result
  }

  def map(p: ((String, String)) => (String, String)): SimpleMap = {
    val result = new SimpleMap
    val iterator = javaMap.entrySet().iterator()
    while (iterator.hasNext) {
      val next = iterator.next()
      val (k, v) = p(next.getKey -> next.getValue)
        result(k) = v
    }
    result
  }

  def flatMap(p: ((String, String)) => SimpleMap): SimpleMap = {
    val result = new SimpleMap
    val iterator = javaMap.entrySet().iterator()
    while (iterator.hasNext) {
      val next = iterator.next()
      val sm = p(next.getKey -> next.getValue)
      result.javaMap.putAll(sm.javaMap)
    }
    result
  }

  def fold(zero: String)(acc: (String, (String, String)) => String): String = {
    var result = zero
    val iterator = javaMap.entrySet().iterator()
    while (iterator.hasNext) {
      val next = iterator.next()
      result = acc(result, next.getKey -> next.getValue)
    }
    result
  }

  def collect(pf: PartialFunction[(String, String), (String, String)]): SimpleMap = {
    val result = new SimpleMap
    val iterator = javaMap.entrySet().iterator()
    while (iterator.hasNext) {
      val next = iterator.next()
      val tuple = next.getKey -> next.getValue
      if (pf.isDefinedAt(tuple)) {
        val (k, v) = pf(tuple)
        result(k) = v
      }
    }
    result
  }

  def get(k: String): Option[String] = {
    Option(javaMap.get(k))
  }
}
