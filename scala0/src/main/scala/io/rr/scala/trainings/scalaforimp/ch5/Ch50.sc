class Counter {
  private var value = 0
  def increment() { value += 1 }
  def current() = value
}
val myCounter = new Counter // Or new Counter()
myCounter.increment()
println(myCounter.current)

myCounter.current // OK
myCounter.current() // Also OK

myCounter.increment() // Use () with mutator
println(myCounter.current) // Don't use () with accessor

class Person {
  var age = 0
}
val fred = new Person
println(fred.age) // Calls the method fred.age()
fred.age = 21 // Calls fred.age_=(21)

class Counter1 {
  private var value = 0
  def increment() { value += 1 }
//  def isLess(other : Counter) = value < other.value
  // Can not access private field of other object
}

class Counter2 {
  private var value = 0
  def increment() { value += 1 }
    def isLess(other : Counter2) = value < other.value
  // Can access private field of other object
}

class Counter3 {
  private[this] var value = 0
  def increment() { value += 1 }
//    def isLess(other : Counter3) = value < other.value
  // Can not access  - private[this]
}

class Person0 {
  private var name = ""
  private var age = 0
  def this(name: String) { // An auxiliary constructor
    this() // Calls primary constructor
    this.name = name
  }
  def this(name: String, age: Int) { // Another auxiliary constructor
    this(name) // Calls previous auxiliary constructor
    this.age = age
  }
}

class Person1(name: String, age: Int) {
  println(s"$name is $age years old.")
  val n = name
}
val p1 = new Person1("John", 22)
//p1.name

class Person2(name: String, age: Int) {
}

val p2 = new Person2("John", 22)
//p2.name









