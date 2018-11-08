import org.apache.spark.sql.catalyst.expressions.Exp


//object accounts {
//  def consolidated(accts: List[BankAccount]): Signal[Int]
//}

class BankAccount {
  val balance = Var(0)

  def currentBalance = balance

  def deposit(amount: Int): Unit =
    if (amount > 0) {
      balance() = balance() + amount
    }

  def withdraw(amount: Int): Unit =
    if (amount > 0 && balance() >= amount) {
      balance() = balance() - amount
    } else throw new Throwable("not enough money")
}

class Signal[T](expr: => T) {
  def apply(): T = ???
}

object Signal {
  def apply[T](expr: => T) = new Signal(expr)
}

class Var[T](expr: => T) extends Signal[T](expr) {
  def update(expr: => T): Unit = ???
}

object Var {
  def apply[T](expr: => T) = new Var(expr)
}

