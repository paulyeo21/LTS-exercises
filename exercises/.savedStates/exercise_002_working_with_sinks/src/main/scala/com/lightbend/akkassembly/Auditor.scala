package com.lightbend.akkassembly

import akka.stream.scaladsl.Sink
import akka.Done
import akka.event.LoggingAdapter
import scala.concurrent.Future

class Auditor {
  val count: Sink[Int, Future[Int]] = Sink.fold[Int, Int](0) {
    case (sum, _) => sum + 1
  }

  def log(implicit logger: LoggingAdapter): Sink[Any, Future[Done]] =
    Sink.foreach[Any](elem => logger.debug("{}", elem))
}