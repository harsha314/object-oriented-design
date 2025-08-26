package com.designpatterns.creationalpatterns.factory.logisticssystem;

import com.designpatterns.creationalpatterns.factory.logisticssystem.transport.SeaTransport;
import com.designpatterns.creationalpatterns.factory.logisticssystem.transport.Transport;

public class SeaLogistics extends Logistics {
  @Override
  public Transport createTransport() {
    return new SeaTransport();
  }
}
