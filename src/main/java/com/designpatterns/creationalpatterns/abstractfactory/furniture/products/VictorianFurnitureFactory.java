package com.designpatterns.creationalpatterns.abstractfactory.furniture.products;

public class VictorianFurnitureFactory implements FurnitureFactory {
  @Override
  public Chair createChair() {
    return new VictorianChair();
  }

  @Override
  public Table createTable() {
    return new VictorianTable();
  }
}
