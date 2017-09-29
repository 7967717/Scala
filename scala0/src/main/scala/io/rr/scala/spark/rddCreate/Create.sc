import org.apache.spark.{SparkConf, SparkContext}

val conf = new SparkConf().setAppName("Create RDD").setMaster("local[*]")
val sc = new SparkContext(conf)

val list = List("Winnie the Pooh", "The Tigger Movie", "Pirates of the Caribbean",
  "Apollo 13", "Mall Cop", "Mockingjay - Part 1", "The Good Dinosaur", "Lava",
  "The Peanuts Movie")

list.take(3)




//val csvArray = sc.textFile("file:///Rev.csv").map(line => line.split(",") )