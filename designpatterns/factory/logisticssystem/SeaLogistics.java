package designpatterns.factory.logisticssystem;

import designpatterns.factory.logisticssystem.transport.SeaTransport;
import designpatterns.factory.logisticssystem.transport.Transport;

public class SeaLogistics extends Logistics {
  @Override
  public Transport createTransport() {
    return new SeaTransport();
  }
}
