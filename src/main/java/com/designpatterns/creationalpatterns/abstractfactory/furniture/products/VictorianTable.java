package com.designpatterns.creationalpatterns.abstractfactory.furniture.products;

public class VictorianTable implements Table {
  @Override
  public void placeItem() {
    System.out.println("Putting items on an elegent Victorian Table");
  }

  @Override
  public String getStyle() {
    return "Victorian";
  }
}
