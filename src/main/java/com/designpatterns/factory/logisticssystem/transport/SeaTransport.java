package com.designpatterns.factory.logisticssystem.transport;

public class SeaTransport implements Transport {
  @Override
  public void deliver() {
    System.out.println("Delivered by Sea");
  }
}
