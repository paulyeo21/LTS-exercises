package com.lightbend.akkassembly

import akka.stream.scaladsl.Source
import akka.NotUsed

class WheelShop {
  val wheels: Source[Wheel, NotUsed] =
    Source.repeat(new Wheel)
}