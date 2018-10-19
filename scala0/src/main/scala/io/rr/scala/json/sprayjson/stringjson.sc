import spray.json.JsString

import scala.util.parsing.json._
import com.typesafe.config
import com.typesafe.config.ConfigFactory
import spray.json._
import DefaultJsonProtocol._

val factory = ConfigFactory.parseString("bssapi-databroker {\n  rest {\n    host = 0.0.0.0\n    host = ${?DATABROKER_REST_HOST}\n    port = 8080\n    port = ${?DATABROKER_REST_PORT}\n  }\n  kafka {\n    service = \"kafka\"\n  }\n  qartifact {\n    host = 0.0.0.0\n    port = 8118\n  }\n}")

val config = factory.getConfig("bssapi-databroker")
config.getConfig("kafka").getString("service")
val s = config.toString
//s.substring(s.indexOf("{"), s.lastIndexOf("}")).replaceAll("$, ?", "").parseJson.prettyPrint
val v = "Default config - Config(SimpleConfigObject({\"consul\":{\"service\":\"cp-consul-8500\"},\"kafka\":{\"default\":{\"address\":\"localhost\",\"port\":9092},\"service\":\"kafka-9092\"},\"rest\":{\"address\":\"0.0.0.0\",\"port\":8080}}))"
v.substring(v.indexOf("{"), v.indexOf(")")).parseJson.prettyPrint
