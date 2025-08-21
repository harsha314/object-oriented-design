package com.designpatterns.factory.logisticssystem;

import com.designpatterns.factory.logisticssystem.transport.SeaTransport;
import com.designpatterns.factory.logisticssystem.transport.Transport;

public class SeaLogistics extends Logistics {
  @Override
  public Transport createTransport() {
    return new SeaTransport();
  }
}
