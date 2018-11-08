import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JButton

import scala.math._

val num = 3.14

val fun = ceil _
//the same
val fun0: Double => Double = ceil

val fun1 = ceil(num)
fun(num)
fun0(num)

Array(3.14, 1.42, 2.0).map(fun)
Array(3.14, 1.42, 2.0).map(x => x *10)

val triple0 = (x: Double) => 3 * x
//the same
def triple1(x: Double) = 3 * x
triple0(3.0)
triple1(3.0)

def valueAtOneQuarter(f: (Double) => Double) = f(0.25)
valueAtOneQuarter(triple0)
valueAtOneQuarter(triple1)

valueAtOneQuarter(ceil _)
valueAtOneQuarter(sqrt _)

def mulBy(factor : Double) = (x : Double) => factor * x
val quintuple = mulBy(5.0)
quintuple(20.0)

valueAtOneQuarter(x => 3 * x)
//the same
valueAtOneQuarter(3 * _)

(1 to 9).map(0.1 * _)
(1 to 9).map("*" * _).foreach(println _)
(1 to 9).filter(_ % 2 == 0)

(1 to 9).reduceLeft(_ * _)
(1 to 9).product
1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9

"Mary had a little lamb".split(" ").sortWith(_.length < _.length)
"Mary had a little lamb".split(" ").sortWith(_.length > _.length)

val triple = mulBy(3)
val half = mulBy(0.5)
println(s"${triple(14)} ${half(14)}")

var counter = 0
val button = new JButton("Increment")

button.addActionListener(new ActionListener {
  override def actionPerformed(event: ActionEvent) {
    counter += 1
  }
})
//the same
button.addActionListener(event => counter += 1)

//val listener = (event: ActionListener) => println(counter)
//button.addActionListener(listener)

val listener: ActionListener = event => println(counter)
button.addActionListener(listener)

