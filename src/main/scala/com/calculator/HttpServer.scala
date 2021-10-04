package com.calculator

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import de.heikoseeberger.akkahttpcirce.ErrorAccumulatingCirceSupport
import io.circe.{Decoder, Encoder}

import scala.concurrent.ExecutionContext

case class CurrencyPayload(from: Option[String], to: Option[String], value: BigDecimal)

//marshaling/unmarshaling to JSON for CurrencyPayload
trait Protocols extends ErrorAccumulatingCirceSupport {
  import io.circe.generic.semiauto._

  implicit val currencyRequestDecoder: Decoder[CurrencyPayload] = deriveDecoder
  implicit val currencyRequestEncoder: Encoder[CurrencyPayload] = deriveEncoder
}

trait Service extends Protocols {
  implicit val system: ActorSystem
  // can execute program logic asynchronously
  implicit def executor: ExecutionContext
}

object HttpServer extends App with Service {
  //initialize Actor system for Akka HTTP
  override implicit val system: ActorSystem = ActorSystem()
  override implicit val executor: ExecutionContext = system.dispatcher

  val routes: Route =
    path("health") {
      get {
        complete(StatusCodes.OK)
      }
    } ~
      pathPrefix("eur") {
        (get & path(Segment)) { ip =>
          complete(StatusCodes.OK)
        } ~
          (post & entity(as[CurrencyPayload])) { currencyPayload =>
            complete(StatusCodes.OK)
          }
      }

  Http().newServerAt("localhost", 8080).bindFlow(routes)
}
