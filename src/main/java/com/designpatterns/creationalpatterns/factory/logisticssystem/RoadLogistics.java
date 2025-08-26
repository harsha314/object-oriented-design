package com.designpatterns.creationalpatterns.factory.logisticssystem;

import com.designpatterns.creationalpatterns.factory.logisticssystem.transport.RoadTransport;
import com.designpatterns.creationalpatterns.factory.logisticssystem.transport.Transport;

public class RoadLogistics extends Logistics {
  @Override
  public Transport createTransport() {
    return new RoadTransport();
  }
}
