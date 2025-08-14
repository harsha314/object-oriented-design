package designpatterns.factory.logisticssystem;

import designpatterns.factory.logisticssystem.transport.RoadTransport;
import designpatterns.factory.logisticssystem.transport.Transport;

public class RoadLogistics extends Logistics {
  @Override
  public Transport createTransport() {
    return new RoadTransport();
  }
}
