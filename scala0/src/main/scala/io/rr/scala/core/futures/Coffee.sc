import scala.util.Try
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

type CoffeeBeans = String
type GroundCoffee = String

case class Water(temperature: Int)

type Milk = String
type FrothedMilk = String
type Espresso = String
type Cappuccino = String

case class GrindingException(msg: String) extends Exception(msg)

case class FrothingException(msg: String) extends Exception(msg)

case class WaterBoilingException(msg: String) extends Exception(msg)

case class BrewingException(msg: String) extends Exception(msg)

////Sequential
//def grind(beans: CoffeeBeans): GroundCoffee = s"ground coffee of $beans"
//def heatWater(water: Water): Water = water.copy(temperature = 85)
////def frothMilk(milk: Milk): FrothedMilk = s"frothed $milk"
//def frothMilk(milk: Milk): FrothedMilk = throw FrothingException("no milk")
//def brew(coffee: GroundCoffee, heatedWater: Water): Espresso = "espresso"
def combine(espresso: Espresso, frothedMilk: FrothedMilk): Cappuccino = "cappuccino"

//Concurrent
def grind(beans: CoffeeBeans): Future[GroundCoffee] = Future {
  println("start grinding...")
  Thread.sleep(Random.nextInt(2000))
  if (beans == "baked beans") throw GrindingException("are you joking?")
  println("finished grinding...")
  s"ground coffee of $beans"
}
def heatWater(water: Water): Future[Water] = Future {
  println("heating the water now")
  Thread.sleep(Random.nextInt(2000))
  println("finished heating")
  water.copy(temperature = 85)
}
def checkTemperature(heatedWater: Water): Future[Water] = Future {
  println("checking water!")
  if ((80 to 85).contains(heatedWater.temperature)) {
    println("hot, it's hot!")
    heatedWater
  }
  else {
    println("it's Not hot!")
    throw WaterBoilingException("not hot!")
  }
}
def frothMilk(milk: Milk): Future[FrothedMilk] = Future {
  println("milk frothing system engaged!")
  Thread.sleep(Random.nextInt(2000))
  println("shutting down milk frothing system")
  s"frothed $milk"
}
def brew(coffee: GroundCoffee, heatedWater: Water): Future[Espresso] = Future {
  println("happy brewing :)")
  Thread.sleep(Random.nextInt(2000))
  println("it's brewed!")
  s"$coffee plus $heatedWater = espresso"
}

def prepareCappuccinoSequentially(): Future[Cappuccino] = {
  for {
    ground <- grind("arabica beans")
    water <- heatWater(Water(20))
    foam <- frothMilk("milk")
    espresso <- brew(ground, water)
  } yield combine(espresso, foam)
}
prepareCappuccinoSequentially().foreach(println)

def prepareCappuccinoParallel(): Future[Cappuccino] = {
  // for parallel computation
  val ground = grind("arabica beans")
  val water = heatWater(Water(25))
  val foam = frothMilk("milk")
  for {
    g <- ground
    w <- water
    f <- foam
    w <- checkTemperature(w)
    espresso <- brew(g, w)
  } yield combine(espresso, f)
}
prepareCappuccinoParallel().foreach(println)

Thread.sleep(12000)