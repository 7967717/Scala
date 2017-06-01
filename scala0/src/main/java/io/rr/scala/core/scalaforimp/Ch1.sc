var a = 8 * 5 + 2
var s0 = "Hello " + a
s0.toLowerCase

val greeting: String = null
greeting + a
//greeting = "g"

1.to(10)

"Hello".intersect("World")
"Hello" intersect "World"

var counter: Int = 1
counter+=1
counter

//2+=1  do not work

val x: BigInt = 1234567890
x * x * x

"Bonjour".sorted
"Bonjour" sorted

import scala.math._
sqrt(2)
pow(2, 4)
min(3, Pi)

BigInt.probablePrime(100, scala.util.Random)

val s = "Hello"
s(4)
s.apply(4) //the same

BigInt("1234567890")
BigInt.apply("1234567890") //the same

Array(1, 4, 9, 16)
Array.apply(1, 4, 9, 16) //the same

s.count(_.isUpper)
s.count(_.isLower)

'r'.to('u')
"Bierstube".containsSlice('r'.to('u'))

"Scala".sorted
"Java Scala".sorted

val b = sqrt(3)
b * b

"crazy" * 3

10 max 2

BigInt(2).pow(1024)

import scala.math.BigInt._
import scala.util.Random
probablePrime(100, Random)

"Scala"(0)
"Scala".last
"Scala".take(1)
"Scala".drop(1)
"Scala".takeRight(2)
"Scala".dropRight(2)