package io.rr.scala.spark.sparkwith

import org.apache.spark.SparkContext

/**
  * @author rrudenko on 31.10.2017.
  */
object FriendsByName {

  private def takefriends(line: String): (String, Int) = {
//  private def takefriends(line: String): (Int, Int) = {
    val lines = line.split(",")
    val name = lines(1)
//    val age = lines(2).toInt
    val friends = lines(3).toInt
    (name, friends)
  }

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "FriendsByAge")
    val lines = sc.textFile("../scala0/src/main/resources/sparkwith/fakefriends.csv")

    val tuples = lines.map(takefriends)
    val values = tuples.mapValues(x => (x, 1)).reduceByKey((x,y) => (x._1 + y._1, x._2 + y._2))
    val sorted = values.mapValues(x => x._1 / x._2).collect().sorted
    sorted.foreach(x => println(x))
  }

}
