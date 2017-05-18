package org.scalatrain.basic.task

object SimpleMap {
  def apply[K, V](args: (K, V)*): SimpleMap[K, V] = {
    val result = new SimpleMap[K, V]
    args.foreach{case (k, v) => result(k) = v }
    result
  }
}

class SimpleMap[K, V] extends Function1[K, V]{

  val javaMap = new java.util.HashMap[K, V]()

  override def toString(): String = javaMap.toString()

  def update(k: K, v: V): V = javaMap.put(k, v)
  def apply(k: K): V = javaMap.get(k)
  def -=(k: K): V = javaMap.remove(k)
  def f(m: SimpleMap[K, V] => SimpleMap[K, V]): SimpleMap[K, V] = new SimpleMap[K, V]

  def size: Int = javaMap.size()

  def filterKey(p: K => Boolean): SimpleMap[K, V] = {
    val result = new SimpleMap[K, V]
    val iterator = javaMap.entrySet().iterator()
    while (iterator.hasNext) {
      val next = iterator.next()
      if (p(next.getKey)) {
        result(next.getKey) = next.getValue
      }
    }
    result
  }

  def filter(p: ((K, V)) => Boolean): SimpleMap[K, V] = {
    val result = new SimpleMap[K, V]
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

  def map[K1, V1](p: ((K, V)) => (K1, V1)): SimpleMap[K1, V1] = {
    val result = new SimpleMap[K1, V1]
    val iterator = javaMap.entrySet().iterator()
    while (iterator.hasNext) {
      val next = iterator.next()
      val (k, v) = p(next.getKey -> next.getValue)
        result(k) = v
    }
    result
  }

  def flatMap[K1, V1](p: ((K, V)) => SimpleMap[K1, V1]): SimpleMap[K1, V1] = {
    val result = new SimpleMap[K1, V1]
    val iterator = javaMap.entrySet().iterator()
    while (iterator.hasNext) {
      val next = iterator.next()
      val sm = p(next.getKey -> next.getValue)
      result.javaMap.putAll(sm.javaMap)
    }
    result
  }

  def fold[A](zero: A)(acc: (A, (K, V)) => A): A = {
    var result = zero
    val iterator = javaMap.entrySet().iterator()
    while (iterator.hasNext) {
      val next = iterator.next()
      result = acc(result, next.getKey -> next.getValue)
    }
    result
  }

  def collect(pf: PartialFunction[(K, V), (K, V)]): SimpleMap[K, V] = {
    val result = new SimpleMap[K, V]
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

  def get(k: K): Option[V] = {
    Option(javaMap.get(k))
  }
}
