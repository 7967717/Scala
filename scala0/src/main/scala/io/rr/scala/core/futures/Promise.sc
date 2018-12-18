import concurrent.Future
import concurrent.ExecutionContext.Implicits.global
val f: Future[String] = Future { "Hello world!" }

import concurrent.Promise
case class TaxCut(reduction: Int)
val taxcut = Promise[TaxCut]()
val taxcutF0: Future[TaxCut] = taxcut.future
val taxcutF1: Future[TaxCut] = taxcut.future
taxcutF0 == taxcutF1
taxcut.success(TaxCut(20))
//taxcut.success(TaxCut(20)) throws Exception

case class LameExcuse(msg: String) extends Exception(msg)
object Government {
  def redeemCampaignPledge(): Future[TaxCut] = {
    val p = Promise[TaxCut]()
    Future {
      println("Starting the new legislative period.")
      Thread.sleep(2000)
      p.failure(LameExcuse("global economy crisis"))
      println("We didn't fulfill our promises, but surely they'll understand.")
//      p.success(TaxCut(20))
//      println("We reduced the taxes! You must reelect us!!!!1111")
    }
    p.future
  }
}

import scala.util.{Success, Failure}
val taxCutF: Future[TaxCut] = Government.redeemCampaignPledge()
println("Now that they're elected, let's see if they remember their promises...")
taxCutF.onComplete {
  case Success(TaxCut(reduction)) =>
    println(s"A miracle! They really cut our taxes by $reduction percentage points!")
  case Failure(ex) =>
    println(s"They broke their promises! Again! Because of a ${ex.getMessage}")
}
Thread.sleep(3000)