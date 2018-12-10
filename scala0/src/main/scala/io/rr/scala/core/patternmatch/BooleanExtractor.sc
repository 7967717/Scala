trait User {
  def name: String
  def score: Int
}
class FreeUser(val name: String, val score: Int, val upgradeProbability: Double)
  extends User
class PremiumUser(val name: String, val score: Int) extends User

object FreeUser {
  def unapply(user: FreeUser): Option[(String, Int, Double)] =
    Some((user.name, user.score, user.upgradeProbability))
}
object PremiumUser {
  def unapply(user: PremiumUser): Option[(String, Int)] = Some((user.name, user.score))
}

val user: User = new FreeUser("Daniel", 3000, 0.7d)
user match {
  case FreeUser(name, _, p) =>
    if (p > 0.75) name + ", what can we do for you today?" else "Hello " + name
  case PremiumUser(name, _) => "Welcome back, dear " + name
}

object premiumCandidate {
  def unapply(user: FreeUser): Boolean = user.upgradeProbability > 0.75
}

val user0: User = new FreeUser("Daniel", 2500, 0.8d)

user0 match {
  case freeUser @ premiumCandidate() => "Spamming " + freeUser
  case _ => "Newsing " + user0
}

user match {
  case freeUser @ premiumCandidate() => "Spamming " + freeUser
  case _ => "Newsing " + user0
}