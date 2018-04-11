
import spray.json._
import DefaultJsonProtocol._

val source = """{ "some": "JSON source" }"""
val jsonAst = source.parseJson
jsonAst.prettyPrint
jsonAst.compactPrint

val json = List(1, 2, 3).toJson

case class Child(name: String, age: Int, birthdate: Option[Int])

class UsageEvents (_id: String = java.util.UUID.randomUUID().toString,
                   _agreement_id: String = null,
                   _created_at: String = null) {
  var id: java.lang.String = _id
  var agreement_id: java.lang.String = _agreement_id
  var created_at: java.lang.String = _created_at
}


object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val childFormat = jsonFormat3(Child)
  implicit object UsageEventsFormats extends RootJsonFormat[UsageEvents] {
    override def write(obj: UsageEvents) =
      JsArray(JsString(obj.id), JsString(obj.agreement_id), JsString(obj.created_at))

    override def read(json: JsValue) = ???
  }
}

import MyJsonProtocol._
val ser = Child("Mary", 5, Some(1111)).toJson
ser.prettyPrint
val usage = new UsageEvents("f12a70b9-2b3f-432a-8366-317359798e5a",
  "e252f67a-369d-43f6-8749-9c546f9366ec", "Tue Mar 20 18:39:46 EET 2018")
usage.toJson