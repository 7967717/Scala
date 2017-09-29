trait Expr
case class Number(n: Int) extends Expr
case class Var(x: String) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr

def show(e: Expr): String = e match {
  case Number(x) => x.toString
  case Var(x) => x.toString
  case Sum(l, r) => show(l) + " + " + show(r)
  case Prod(Sum(sl, sr), r) => "(" + show(Sum(sl, sr)) + ")" + " * " + show(r)
  case Prod(l, r) => show(l) + " * " + show(r)
}

show(Sum(Number(1), Number(2)))
show(Sum(Prod(Number(2), Var("x")), Var("y")))
show(Prod(Sum(Number(2), Var("x")), Var("y")))