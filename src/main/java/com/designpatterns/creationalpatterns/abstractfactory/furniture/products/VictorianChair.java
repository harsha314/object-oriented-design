package com.designpatterns.creationalpatterns.abstractfactory.furniture.products;

public class VictorianChair implements Chair {
  @Override
  public void sitOn() {
    System.out.println("Sitting on a Victorian Chair");
  }

  @Override
  public String getStyle() {
    return "Victorian";
  }
}
