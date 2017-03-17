package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else if (c > r) throw new java.util.NoSuchElementException("no such element")
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    def check(charList: List[Char], count: Int): Int = {
      if (charList.isEmpty)
        count
      else if (charList.head == '(')
        check(charList.tail, count + 1)
      else if (charList.head == ')' && count > 0)
        check(charList.tail, count - 1)
      else
        check(charList.tail, count)
    }

    if (chars.count(_.equals('(')) == chars.count(_.equals(')')))
      check(chars, 0) == 0
    else
      false
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {

    def count(money: Int, coins: List[Int]): Int = {
      if (money == 0)
        1
      else if (money < 0)
        0
      else if (coins.isEmpty && money >= 1)
        0
      else
        count(money, coins.tail) + count(money - coins.head, coins)
    }

    count(money, coins.sortWith(_.compareTo(_) < 0))

  }
}
