name := "currency-calculator"
version := "1.0"
scalaVersion := "2.13.6"

val AkkaVersion = "2.6.14"
val AkkaHttpVersion = "10.2.4"
val circeVersion = "0.14.0"
val akkaHttpCirceVersion = "1.36.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-testkit" %  AkkaVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % AkkaHttpVersion,
  "io.circe"          %% "circe-core" % circeVersion,
  "io.circe"          %% "circe-generic" % circeVersion,
  "de.heikoseeberger" %% "akka-http-circe" % akkaHttpCirceVersion,
)