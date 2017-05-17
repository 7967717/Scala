package org.scalatrain.basic.task

class SimpleMap {

  val javaMap = new java.util.HashMap[String, String]()
  def update(k: String, v: String): String = javaMap.put(k, v)
  def apply(k: String): String = javaMap.get(k)
  def -=(k: String): String = javaMap.remove(k)
  def f(m: SimpleMap => SimpleMap): SimpleMap = new SimpleMap

  def size: Int = javaMap.size()
  def filterKey(p: String => Boolean): SimpleMap = ???
  def filter(p: ((String, String)) => Boolean): SimpleMap = ???
  def map(p: ((String, String)) => (String, String)): SimpleMap = ???
  def flatMap(p: ((String, String)) => SimpleMap): SimpleMap = ???
  def fold(zero: String)(acc: (String, (String, String)) => String): String = ???
  def collect(pf: PartialFunction[(String, String), (String, String)]): SimpleMap = ???
  def get(k: String): Option[String] = ???
}
