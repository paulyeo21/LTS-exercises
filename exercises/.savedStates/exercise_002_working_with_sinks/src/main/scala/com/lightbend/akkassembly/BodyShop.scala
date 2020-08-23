package com.lightbend.akkassembly

import akka.stream.scaladsl.Source
import akka.actor.Cancellable
import scala.concurrent.duration._

class BodyShop(buildTime: FiniteDuration) {
  val cars: Source[UnfinishedCar, Cancellable] =
    Source.tick(buildTime, buildTime, new UnfinishedCar)
}

