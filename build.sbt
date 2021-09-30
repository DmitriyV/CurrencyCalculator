name := "currency-calculator"

version := "0.1"

scalaVersion := "2.13.6"

val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.6"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-testkit" %  AkkaVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % AkkaHttpVersion,
  "org.specs2" %% "specs2-core" % "4.5.1"
)