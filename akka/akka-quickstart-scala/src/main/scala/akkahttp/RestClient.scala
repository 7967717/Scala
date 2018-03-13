package akkahttp

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer
import akka.http.scaladsl.unmarshalling.Unmarshal
import spray.json.DefaultJsonProtocol

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

object Client {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    val request = HttpRequest(uri = "http://52.50.178.165:8080/api/individuals/juanita")

    val responseFuture: Future[HttpResponse] = Http().singleRequest(request)


    val result = responseFuture.map {
      case HttpResponse(StatusCodes.OK, headers, entity, _) =>
        Unmarshal(entity).to[String]

      case x => s"Unexpected status code ${x.status}"

    }

    println(Await.result(result, 10.seconds))

//    responseFuture
//      .onComplete {
//        case Success(res) => println(res)
//        case Failure(_)   => sys.error("something wrong")
//      }
  }
}


