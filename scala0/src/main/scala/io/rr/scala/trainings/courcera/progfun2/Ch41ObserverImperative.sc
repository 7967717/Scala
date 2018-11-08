
val a = new BankAccount
val b = new BankAccount
val c = new Observer(List(a, b))
c.totalBalance
a.deposit(20)
c.totalBalance
b.deposit(30)
c.totalBalance




class Observer(observed: List[BankAccount]) extends Subscriber {
  observed.foreach(_.subscribe(this))

  private var total = 0
  compute()

  def compute() = {
    total = observed.map(_.currentBalance).sum
  }

  override def handler(publisher: Publisher): Unit = compute()

  def totalBalance = total
}


trait Publisher {
  private var subscribers: Set[Subscriber] = Set()

  def subscribe(subscriber: Subscriber): Unit = subscribers += subscriber

  def unsubscribe(subscriber: Subscriber): Unit = subscribers -= subscriber

  def publish(): Unit = subscribers.foreach(_.handler(this))
}

trait Subscriber {
  def handler(publisher: Publisher)
}

class BankAccount extends Publisher {
  private var balance = 0

  def currentBalance = balance

  def deposit(amount: Int): Unit =
    if (amount > 0) {
      balance = balance + amount
      publish()
    }

  def withdraw(amount: Int): Unit =
    if (amount > 0 && balance >= amount) {
      balance = balance - amount
      publish()
    } else throw new Throwable("not enough money")
}