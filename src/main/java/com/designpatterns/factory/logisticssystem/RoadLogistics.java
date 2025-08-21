package com.designpatterns.factory.logisticssystem;

import com.designpatterns.factory.logisticssystem.transport.RoadTransport;
import com.designpatterns.factory.logisticssystem.transport.Transport;

public class RoadLogistics extends Logistics {
  @Override
  public Transport createTransport() {
    return new RoadTransport();
  }
}
