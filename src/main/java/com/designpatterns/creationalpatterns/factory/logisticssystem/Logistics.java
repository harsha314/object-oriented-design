package com.designpatterns.creationalpatterns.factory.logisticssystem;

import com.designpatterns.creationalpatterns.factory.logisticssystem.transport.Transport;

public abstract class Logistics {
  public abstract Transport createTransport();

  public void planDelivery() {
    Transport transport = createTransport();
    System.out.println("Planning delivery route");
    transport.deliver();
  }
}
