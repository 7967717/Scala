val host: Option[String] = Some("addr")
//val port: Option[Int] = Some(80)
val port: Option[Int] = None

case class InetAddress (h: String, p: Int)

val addr: Option[InetAddress] =
  host flatMap { h =>
    port map { p =>
      InetAddress(h, p)
    }
  }

val addr1: Option[InetAddress] = for {
  h <- host
  p <- port
} yield InetAddress(h, p)

val chars = 'a' to 'z'
val perms = for {
  a <- chars
  b <- chars
  if a != b
} yield "%c%c".format(a, b)


val h1 = for {
//  x <- host
  x <- port
} yield x