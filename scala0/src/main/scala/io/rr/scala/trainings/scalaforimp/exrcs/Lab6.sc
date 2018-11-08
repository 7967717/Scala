val zones = java.util.TimeZone.getAvailableIDs

zones.map(_.split("/")).flatten
zones.flatMap(_.split("/"))
zones.map(_.split("/")).filter(_.size > 1).map(_ (1)).grouped(10)
  .toList.map(_ (0))

(1 to 10).reduceLeft(_ * _)
def fact(n: Int) = (1 to n).reduceLeft(_ * _)
fact(10)

//def pover2(n: Int) = (1 to n).map(e => 2).product    the same
def pover2(n: Int) = (1 to n).map(e => 2).reduceLeft(_ * _)
pover2(2)
pover2(10)

def concat(strings: Seq[String], sep: String) = strings.reduceLeft(_ + sep + _)
concat(List("a", "b", "c"), "_")

def While(p: => Boolean)(f: => Unit) {
  if (p) {
    f; While(p)(f)
  }
}


val n = 10
var i = 1
var f = 1
While(i < n) {f *= i; i += 1}
f