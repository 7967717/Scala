val addTen = (a: Int) => a + 10

val double = (a: Int) => a * 2

val combined = addTen andThen double // this composes the two functions

combined(5)
