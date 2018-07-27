import spray.json.JsString

import scala.util.parsing.json._
import com.typesafe.config
import com.typesafe.config.ConfigFactory

val factory = ConfigFactory.parseString("bssapi-databroker {\n  rest {\n    host = 0.0.0.0\n    host = ${?DATABROKER_REST_HOST}\n    port = 8080\n    port = ${?DATABROKER_REST_PORT}\n  }\n  kafka {\n    service = \"kafka\"\n  }\n  qartifact {\n    host = 0.0.0.0\n    port = 8118\n  }\n}")

factory.getConfig("bssapi-databroker").getConfig("kafka").getString("service")

