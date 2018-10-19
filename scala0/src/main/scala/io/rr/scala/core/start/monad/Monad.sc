case class User (name: Int) {
  val child: Option[User] = {
    if(name < 3) {
      println(name)
      Some(User(name + 1))
    } else {
      println(name)
      None
    }
  }
}

def loadUser(name: Int): Option[User] = {
    Some(User(name))
  }

val getChild = (user: User) => user.child

loadUser(1)
  .flatMap(getChild)
  .flatMap(getChild)
  .flatMap(getChild)


val result = for {
  user             <- loadUser(1)
  usersChild       <- user.child
  usersGrandChild  <- usersChild.child
} yield usersGrandChild

val u: Option[User] = None
u.flatMap(getChild)
u.flatMap(getChild).flatMap(getChild)
u.flatMap(getChild).flatMap(getChild).map(x => x)