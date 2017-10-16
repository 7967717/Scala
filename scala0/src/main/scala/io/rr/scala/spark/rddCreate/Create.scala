package io.rr.scala.spark.rddCreate

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author roman on 3/6/17.
  */
object Create {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Create RDD").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val list = List("Winnie the Pooh", "The Tigger Movie", "Pirates of the Caribbean",
      "Apollo 13", "Mall Cop", "Mockingjay - Part 1", "The Good Dinosaur", "Lava",
      "The Peanuts Movie")

    sc.parallelize(list)

    sc.parallelize(list).take(3)

  }

}
