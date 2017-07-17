import scala.collection.mutable.ArrayBuffer

class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
    override def toString = name
  }
  private val members = new ArrayBuffer[Member]
  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
  def show = println(members)
}

val chatter = new Network
val myFace = new Network

val fred = chatter.join("Fred")
val wilma = chatter.join("Wilma")
chatter.show
fred.contacts += wilma // OK
fred.contacts
val barney = myFace.join("Barney") // Has type myFace.Member
//fred.contacts += barney
// No—can't add a myFace.Member to a buffer of chatter.Member elements






