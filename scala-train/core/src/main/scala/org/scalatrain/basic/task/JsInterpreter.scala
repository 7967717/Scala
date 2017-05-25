package org.scalatrain.basic.task

sealed trait JsExpr {
  def js = this
  def -(rhs: JsExpr) = JsBinOp("-", this, rhs)
  def +(rhs: JsExpr) = JsBinOp("+", this, rhs)
}

trait JsLiteral extends JsExpr
case class JsString(value: String) extends JsLiteral
case class JsNum(value: Int) extends JsLiteral
case class JsBinOp(operator: String, lhs: JsExpr, rhs: JsExpr) extends JsExpr

object JsInterpreter {
  def run(js: JsExpr): String = interpret(js) match {
    case JsNum(v) => v.toString
//    case jsnum: JsNum => jsnum.value.toString  //the same as above
    case JsString(v) => v
//    case JsBinOp("+", JsNum(lhs), JsNum(rhs)) => (lhs + rhs).toString
//    case JsBinOp("-", JsNum(lhs), JsNum(rhs)) => (lhs - rhs).toString
//    case JsBinOp("+", JsString(lhs), JsString(rhs)) => lhs + rhs
//    case JsBinOp("+", JsNum(lhs), JsString(rhs)) => lhs.toString + rhs
//    case JsBinOp("+", JsString(lhs), JsNum(rhs)) => lhs + rhs.toString
//    case JsBinOp("-", JsString(lhs), JsNum(rhs)) => (lhs.toInt - rhs).toString
//    case JsBinOp("-", JsNum(lhs), JsString(rhs)) => (lhs - rhs.toInt).toString
//    case JsBinOp("-", lhs, rhs) => JsBinOp("+", run(lhs), run(rhs))
  }

  def interpret(js: JsExpr): JsLiteral = js match {
    case js: JsNum => js
//    case js @ JsNum(_) => js // the same as above
    case js: JsString => js
    case JsBinOp("+", JsNum(lhs), JsNum(rhs)) => JsNum(lhs + rhs)
    case JsBinOp("-", JsNum(lhs), JsNum(rhs)) => JsNum(lhs - rhs)
    case JsBinOp("-", JsNum(lhs), JsString(rhs)) => JsNum(lhs - rhs.toInt)
    case JsBinOp("+", JsString(lhs), JsString(rhs)) => JsString(lhs + rhs)
    case JsBinOp("+", JsString(lhs), JsNum(rhs)) => JsString(lhs + rhs.toString)
    case JsBinOp("+", JsNum(lhs), JsString(rhs)) => JsString(lhs.toString + rhs)
    case JsBinOp(op, lhs, rhs) =>
      interpret(JsBinOp(op, interpret(lhs), interpret(rhs)))
  }
}
