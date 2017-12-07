
def map[A, B](opt: Option[A], f: A => B): Option[B] = opt match {
  case None => None
  case Some(x) => Some(f(x))
}

def getOrElse[A, B >: A](opt: Option[A], default: => B): B = opt match {
  case None => default
  case Some(x) => x
}

def flatMap[A, B](opt: Option[A], f: A => Option[B]): Option[B] =
  getOrElse(map(opt, f), None)

def orElse[A, B >: A](opt: Option[A], other: => Option[B]): Option[B] = opt match {
  case None => other
  case _ => opt
}

def filter[A](opt: Option[A], f: A => Boolean): Option[A] = opt match {
  case Some(x) if f(x) => Some(x)
  case _ => None
}


