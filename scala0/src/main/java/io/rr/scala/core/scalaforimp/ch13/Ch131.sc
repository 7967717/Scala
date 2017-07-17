import scala.collection.mutable.ArrayBuffer

Set(1, 2, 3, 4, 5, 6).foreach(x => println(x))

val digits = Set(1, 7, 2, 9)
digits contains 0
Set(1, 2) subsetOf digits

val primes = Set(2, 3, 5, 7)

digits union primes
digits intersect primes
digits diff primes

Vector(1, 2, 3) :+ 5
Vector(1, 2, 3).:+(5) //the same
5 +: Vector(1, 2, 3)

val numbers = ArrayBuffer(1, 2, 3)
numbers += 5

var numbers0 = Set(1, 2, 3)
numbers0 += 5
numbers0

var numbers1 = Set(1, 2, 3)
numbers1 + 5
numbers1

var numberVector = Vector(1, 2, 3)
numberVector :+= 5
numberVector

//val numberVector0 = Vector(1, 2, 3)
//numberVector0 :+= 5
//numberVector0

Set(1, 2, 3) - 2
