def contains(list: Seq[String], word: String): Boolean = {
  val middle = list.length / 2
  if (list.isEmpty) false
  else if (list.length == 1)
    list.head == word
  else if (word < list(middle))
    contains(list.dropRight(middle), word)
  else if (word > list(middle))
    contains(list.takeRight(middle), word)
  else true
}

val list = List("one", "two", "three", "four", "five").sorted
list.dropRight(2)
list.takeRight(2)

contains(Nil, "one")
contains(List("one"), "one")
contains(List("one"), "")
contains(list, "")
contains(list, "one")
contains(list, "one")
contains(list, "three")
contains(list, "threu")
contains(list, "ones")

