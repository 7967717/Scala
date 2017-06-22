import scala.collection.{SortedMap, mutable}
import scala.collection.immutable.HashMap

val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
//the same
val scores_ = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))

var scoresM = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
var scoresM1 = scala.collection.mutable.Map[String, Int]()

val bobsScore = scores("Bob")
val bobsScore0 = if (scores.contains("Bob0")) scores("Bob") else 0
//the same
val bobsScore1 = scores.getOrElse("Bob0", 0)

val scores2 = scores.withDefaultValue(0)
val zeldasScore1 = scores2("Zelda")
// Yields 0 since "Zelda" is not present
val scores3 = scores.withDefault(_.length)
val zeldasScore2 = scores3("Zelda")
// Yields 5, applying the length function to the key that is not present

val b = scoresM("Bob") = 11
scoresM
val f = scoresM1("Fred") = 7
scoresM1

scoresM1 += ("Bob" -> 12, "Fred" -> 17)
scoresM1 -= "Bob"

// New map with update
val newScores = scores + ("Bob" -> 10, "Fred" -> 7)

scoresM = scoresM - "Alice"
//the same
scoresM -= "Bob"

scores.keySet
for (v <- scores.values) println(v)
for ((k, v) <- scores) yield (v, k)

val scores4 = SortedMap("Alice" -> 10, "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8)
val months = mutable.LinkedHashMap("January" -> 1, "February" -> 2, "March" -> 3, "April" -> 4, "May" -> 5)
val months0 = HashMap("January" -> 1, "February" -> 2, "March" -> 3, "April" -> 4, "May" -> 5)

import scala.collection.JavaConversions.propertiesAsScalaMap
val props: scala.collection.Map[String, String] = System.getProperties()

val t = (1, 3.14, "Fred")
val second = t._2
"New York".partition(_.isUpper)

val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)
for ((s, n) <- pairs) print(s * n)

for ((k, v) <- months) yield (k, v * 10)



