package com.lightbend.akkassembly

import akka.stream.scaladsl.Source
import akka.NotUsed

class PaintShop(colorSet: Set[Color]) {
  val colors: Source[Color, NotUsed] =
    Source.cycle(() => colorSet.iterator)
}