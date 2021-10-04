package com.calculator

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import com.calculator.http.HealthRoute

import scala.concurrent.ExecutionContext

trait Service {
  implicit val system: ActorSystem
  // can execute program logic asynchronously
  implicit def executor: ExecutionContext
}

object HttpServer extends App with Service {
  override implicit val system: ActorSystem = ActorSystem()
  override implicit val executor: ExecutionContext = system.dispatcher

  Http().newServerAt("localhost", 8080).bindFlow(HealthRoute.healthRoute)
}
