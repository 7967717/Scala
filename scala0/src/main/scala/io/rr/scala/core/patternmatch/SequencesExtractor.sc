object GivenNames {
  def unapplySeq(name: String): Option[Seq[String]] = {
    if (name.isEmpty) None
    else Some(name.trim.split(" "))
  }
}

object Names {
  def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
    val names = name.trim.split(" ")
    if (names.size < 2) None
    else Some((names.last, names.head, names.drop(1).dropRight(1)))
  }
}

def greetWithFirstName(name: String) = name match {
//  case GivenNames(firstName, _*) => "Good morning, " + firstName + "!"
  case Names(lastName, firstName, _*) => "Good morning, " + firstName + " " + lastName + "!"
  case _ => "Welcome! Please make sure to fill in your name!"
}

greetWithFirstName("Hose Alabama Sifuentes")


