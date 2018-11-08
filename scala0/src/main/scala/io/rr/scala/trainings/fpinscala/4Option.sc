
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

def plus(x: Int): Option[Int] = Some(x + x)
map(Some(1), x => plus(x))
flatMap(Some(1), x => plus(x))


def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
  case Nil => Some(Nil)
  case h :: t => h.flatMap(hh => sequence(t).map(hh :: _))
}
sequence(List(Some(1), Some(2), None))


