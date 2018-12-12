case class Customer(age: Int)
class Cigarettes
case class UnderAgeException(message: String) extends Exception(message)
def buyCigarettes(customer: Customer): Cigarettes =
  if (customer.age < 16)
    throw UnderAgeException(s"Customer must be older than 16 but was ${customer.age}")
  else new Cigarettes
try {
    buyCigarettes(Customer(15))
} catch {
    case UnderAgeException(m) => println(m)
}

import scala.util.{Failure, Success, Try}
import java.net.URL
import java.nio.charset.MalformedInputException
def parseURL(url: String): Try[URL] = Try(new URL(url))
parseURL("https://www.google.com/")
parseURL("google/")

parseURL("http://www.google.com").map(_.getProtocol)
parseURL("garbage").map(_.getProtocol)

def inputStreamForURL0(url: String)= parseURL(url).map { u =>
    Try(u.openConnection()).map(conn => Try(conn.getInputStream))
}
def inputStreamForURL(url: String) = parseURL(url).flatMap { u =>
    Try(u.openConnection()).flatMap(conn => Try(conn.getInputStream))
}

def parseHttpURL(url: String) = parseURL(url).filter(_.getProtocol == "http")
parseHttpURL("http://www.google.com")
parseHttpURL("ftp://www.google.com")
parseHttpURL("www.google.com")

parseHttpURL("http://www.google.com").foreach(println)
parseHttpURL("www").foreach(println)

import scala.io.Source
def getURLContent(url: String): Try[Iterator[String]] =
    for {
        url <- parseURL(url)
        connection <- Try(url.openConnection())
        is <- Try(connection.getInputStream)
        source = Source.fromInputStream(is)
    } yield source.getLines()
//getURLContent("http://www.google.com") match {
//    case Success(it) => it.foreach(println)
//    case Failure(ex) => println(ex)
//}

import java.io.FileNotFoundException
(getURLContent("google.com") recover {
    case e: FileNotFoundException => Iterator("Requested page does not exist")
    case e: MalformedInputException => Iterator("Please make sure to enter a valid URL")
    case _ => Iterator("An unexpected error has occurred. We are so sorry!")
}).get.foreach(println)