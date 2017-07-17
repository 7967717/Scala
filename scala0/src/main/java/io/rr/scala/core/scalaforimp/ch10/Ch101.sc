trait Logger {
  def log(msg: String)
}

trait ConsoleLogger extends Logger {
  def log(msg: String) { println(msg) }
}

trait MyLogger extends Logger {
  def log(msg: String) { println("my " + msg) }
}

trait TimestampLogger extends Logger {
  abstract override def log(msg: String) {
    super.log(s"${java.time.Instant.now()} $msg")
  }
}

class Test extends ConsoleLogger with TimestampLogger{}
new Test().log("hello")

class Test0 extends ConsoleLogger{}
new Test0().log("hello")

class Test1 extends MyLogger with TimestampLogger{}
new Test1().log("hello")

class Test2 extends MyLogger{}
new Test2().log("hello")