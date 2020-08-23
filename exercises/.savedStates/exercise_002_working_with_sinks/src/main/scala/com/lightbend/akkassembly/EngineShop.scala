package com.lightbend.akkassembly

import akka.stream.scaladsl.Source
import akka.NotUsed

class EngineShop(shipmentSize: Int) {
  val shipments: Source[Shipment, NotUsed] =
    Source.fromIterator {
      () => Iterator.continually(Shipment(Seq.fill(shipmentSize)(Engine())))
    }
}