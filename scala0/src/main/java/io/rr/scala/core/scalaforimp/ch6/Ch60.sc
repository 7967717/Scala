class Account {

  val id = Account.newUniqueNumber()
  private var balance = 0.0
  def deposit(amount: Double) { balance += amount }

}

object Account { // The companion object

  private var lastNumber = 0
  private def newUniqueNumber() = { lastNumber += 1;
    lastNumber }

}

Array.apply("Mary", "had", "a", "little", "lamb")
Array("Mary", "had", "a", "little", "lamb") //the same

Array(Array(1, 7), Array(2, 9))

Array(100)
new Array(100)

class Account0 private (val id: Int, initialBalance: Double) {

  private var balance = initialBalance

  override def toString: String = id + ", " + balance + ";"

}

object Account0 { // The companion object

  def apply(initialBalance: Double) =
    new Account0(newUniqueNumber(), initialBalance)
    private var lastNumber = 0
    private def newUniqueNumber() = { lastNumber += 1;
    lastNumber }

}

Account0(11)
Account0(22)
Account0(33)





