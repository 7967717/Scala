class Time(h: Int, m: Int) {

  if(h < 0 || h > 23 || m < 0 || m > 59)
    throw new IllegalArgumentException

  def this(h: Int) {this(h, 0) }

  private var minSinceMidnight = h * 60 + m

  def hours: Int = minSinceMidnight / 60
  def min: Int = minSinceMidnight % 60
  def min_=(newMin: Int) {
    if (newMin < 0 || newMin > 59) throw new IllegalArgumentException
    minSinceMidnight = hours * 60 + newMin
  }

  def <(other: Time): Boolean = {
    this.minSinceMidnight < other.minSinceMidnight
  }

  def -(other: Time): Time = {
    var t = this.minSinceMidnight - other.minSinceMidnight
    if(t < 0) t = 24 * 60 + t
    Time(t / 60, t % 60)
  }

  override def toString = f"$hours:$min%02d"
}

object Time {
  def apply(h: Int, m: Int = 0): Time = new Time(h, m)
}

val t1 = new Time(12, 30)
val t2 = new Time(0, 0)
val t3 = Time(23, 59)
val t4 = Time(23)
t1 < t2
t2 < t1
t2.min = 20
t2
t4 - t3
t1 - Time(2)
t2 - Time(2)