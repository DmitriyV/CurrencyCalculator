package com.calculator

import akka.http.scaladsl.model.HttpRequest
import akka.util.ByteString
import com.typesafe.config.{Config, ConfigFactory}
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream._

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.io.StdIn
import scala.util.Success

object TestSingleRequest extends App {
  val testConf: Config = ConfigFactory.parseString("""
    akka.loglevel = INFO
    akka.log-dead-letters = off
    akka.stream.materializer.debug.fuzzing-mode = off
    """)
  implicit val system = ActorSystem("ServerTest", testConf)
  implicit val materializer = ActorMaterializer()
  import system.dispatcher

  val x = Http().singleRequest(HttpRequest(uri = "https://www.floatrates.com/daily/eur.json"))

  val res = Await.result(x, 10.seconds)

  val response = res.entity.dataBytes.runFold(ByteString.empty)(_ ++ _).map(_.utf8String)

  println(Await.result(response, 10.seconds))

  system.terminate()
}