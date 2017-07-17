object TrafficLightColor extends Enumeration {
  val Red, Yellow, Green = Value
}
TrafficLightColor.Red
TrafficLightColor.Yellow
TrafficLightColor.Green
for (c <- TrafficLightColor.values) println(s"${c.id}: $c")

object TrafficLightColor0 extends Enumeration {
  val Red = Value(0, "Stop")
  val Yellow = Value(10) // Name "Yellow"
  val Green = Value("Go") // ID 11
  //  If not specified, the ID is one more than the previously
  // assigned one, starting with zero. The default name is the
  // field name.
}
TrafficLightColor0.Red.id
TrafficLightColor0.Red
TrafficLightColor0.Yellow.id
TrafficLightColor0.Yellow
TrafficLightColor0.Green.id
TrafficLightColor0.Green
TrafficLightColor0.values
for (c <- TrafficLightColor0.values) println(s"${c.id}: $c|")

import TrafficLightColor0._
Red
Yellow
Green

object TrafficLightColor1 extends Enumeration {
  type LightColor = Value
  val Red, Yellow, Green = Value
}
import TrafficLightColor1._
val red: LightColor = TrafficLightColor1.Green

TrafficLightColor1(0) // Calls Enumeration.apply
TrafficLightColor.withName("Red").id