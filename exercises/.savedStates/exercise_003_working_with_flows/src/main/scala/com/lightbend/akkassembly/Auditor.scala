package com.lightbend.akkassembly

import akka.stream.scaladsl._
import akka._
import akka.event.LoggingAdapter
import scala.concurrent._
import scala.concurrent.duration._

class Auditor {
  val count: Sink[Any, Future[Int]] = Sink.fold[Int, Any](0) {
    case (sum, _) => sum + 1
  }

  def log(implicit logger: LoggingAdapter): Sink[Any, Future[Done]] =
    Sink.foreach[Any](elem => logger.debug(elem.toString))

  def sample(sampleSize: FiniteDuration): Flow[Car, Car, NotUsed] =
    Flow[Car].takeWithin(sampleSize)
}