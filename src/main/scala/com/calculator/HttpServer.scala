package com.calculator

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.calculator.http.HealthRoute

object HttpServer extends App {

  implicit val system: ActorSystem = ActorSystem("currency-calculator")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  implicit val log = Logging(system, "main")

  val port = 8080

  val bindingFuture =
    Http().bindAndHandle(HealthRoute.healthRoute, "localhost", port)

  log.info(s"Server started at the port $port")
}
