package com.designpatterns.factory.logisticssystem.transport;

public class RoadTransport implements Transport {
  @Override
  public void deliver() {
    System.out.println("Delivered by Road");
  }
}
