package com.designpatterns.creationalpatterns.abstractfactory.furniture.products;

public class ModernTable implements Table {
  @Override
  public void placeItem() {
    System.out.println("Placing item on a Modern Table");
  }

  @Override
  public String getStyle() {
    return "Modern";
  }
}
