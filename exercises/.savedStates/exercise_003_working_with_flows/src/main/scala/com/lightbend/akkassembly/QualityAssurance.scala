package com.lightbend.akkassembly

import akka.stream.scaladsl._
import akka.NotUsed

class QualityAssurance {
  def isCompleted(car: UnfinishedCar): Boolean = {
    car.color != None && car.engine != None && car.wheels.size == 4
  }

  val inspect: Flow[UnfinishedCar, Car, NotUsed] =
    Flow[UnfinishedCar]
      .collect {
        case car if isCompleted(car) => Car(SerialNumber(), car.color.get, car.engine.get, car.wheels.seq, car.upgrade)
      }
}