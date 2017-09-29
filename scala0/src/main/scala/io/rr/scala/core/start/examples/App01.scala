package io.rr.scala.core.start.examples

/**
  * @author rrudenko on 26.07.2017.
  */
object App01 {
  def main(args: Array[String]): Unit = {
    val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
    val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
    message5.sender
    message5.recipient
    message5.body
  }
}

case class Message(sender: String, recipient: String, body: String)