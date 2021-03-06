name := "akka-quickstart-scala"

version := "1.0"

scalaVersion := "2.12.2"

lazy val akkaVersion = "2.5.15"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor"           % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit"         % akkaVersion,
  "com.typesafe.akka" %% "akka-http"            % "10.1.0-RC1",
  "com.typesafe.akka" %% "akka-stream"          % "2.5.8",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.0-RC1",
  "com.typesafe.akka" %% "akka-testkit"         % "2.5.15"      % "test",
  "org.scalatest"     %% "scalatest"            % "3.0.1"       % "test"
)
