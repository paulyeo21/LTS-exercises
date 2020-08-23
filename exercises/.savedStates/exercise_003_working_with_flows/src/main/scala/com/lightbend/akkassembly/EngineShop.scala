package com.lightbend.akkassembly

import akka.stream.scaladsl._
import akka.NotUsed

class EngineShop(shipmentSize: Int) {
  val shipments: Source[Shipment, NotUsed] =
    Source.fromIterator {
      () => Iterator.continually(
        Shipment(Seq.fill(shipmentSize)(Engine()))
      )
    }

  val engines: Source[Engine, NotUsed] =
    shipments.mapConcat {
      case shipment: Shipment => shipment.engines
    }

  val installEngine: Flow[UnfinishedCar, UnfinishedCar, NotUsed] = {
    Flow[UnfinishedCar]
      .zip(engines)
      .map {
        case (car: UnfinishedCar, engine: Engine) => car.installEngine(engine)
      }
  }
}