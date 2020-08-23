package com.lightbend.akkassembly

import akka.stream.scaladsl._
import akka.NotUsed

class PaintShop(colorSet: Set[Color]) {
  val colors: Source[Color, NotUsed] =
    Source.cycle(() => colorSet.iterator)

  val paint: Flow[UnfinishedCar, UnfinishedCar, NotUsed] =
    Flow[UnfinishedCar]
      .zip(colors)
      .map {
        case (car: UnfinishedCar, color: Color) => car.paint(color)
      }
}