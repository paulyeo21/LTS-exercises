package com.lightbend.akkassembly

import akka.stream.scaladsl._
import akka.NotUsed

class WheelShop {
  val wheels: Source[Wheel, NotUsed] =
    Source.repeat(Wheel())

  val installWheels: Flow[UnfinishedCar, UnfinishedCar, NotUsed] = {
      Flow[UnfinishedCar]
        .zip(wheels.grouped(4))
        .map {
          case (car: UnfinishedCar, wheels: Seq[Wheel]) => car.installWheels(wheels)
        }
  }
}