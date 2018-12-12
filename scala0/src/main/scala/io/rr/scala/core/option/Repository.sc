case class User(
                 id: Int,
                 firstName: String,
                 lastName: String,
                 age: Int,
                 gender: Option[String])

object UserRepository {
  private val users = Map(1 -> User(1, "John", "Doe", 32, Some("male")),
    2 -> User(2, "Johanna", "Doe", 30, None))
  def findById(id: Int): Option[User] = users.get(id)
  def findAll = users.values
}

val user = User(2, "Johanna", "Doe", 30, None)
user.gender match {
  case Some(gender) => println("Gender: " + gender)
  case None => println("Gender: not specified")
}

UserRepository.findById(2).foreach(user => println(user.firstName))
UserRepository.findById(1).foreach(user => println(user.gender))
UserRepository.findById(2).foreach(user => println(user.gender))
UserRepository.findById(3).foreach(user => println(user.gender))

UserRepository.findById(1).map(_.age)
UserRepository.findById(1).flatMap(_.gender)

UserRepository.findById(1).flatMap(_.gender)
UserRepository.findById(2).flatMap(_.gender)
UserRepository.findById(3).flatMap(_.gender)

UserRepository.findById(1).filter(_.age > 30)
UserRepository.findById(2).filter(_.age > 30)
UserRepository.findById(3).filter(_.age > 30)

for {
  user <- UserRepository.findAll
  gender <- user.gender
} yield gender
//the same
for {
  User(_, _, _, _, Some(gender)) <- UserRepository.findAll
} yield gender

case class Resource(content: String)
val resourceFromConfigDir: Option[Resource] = None
val resourceFromClasspath: Option[Resource] = Some(Resource("I was found on the classpath"))
resourceFromConfigDir.orElse(resourceFromClasspath)
resourceFromClasspath.orElse(resourceFromConfigDir)