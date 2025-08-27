package com.designpatterns.creationalpatterns.abstractfactory.furniture.products;

public class ModernChair implements Chair {
  @Override
  public void sitOn() {
    System.out.println("Sitting on a sleek modern chair");
  }

  @Override
  public String getStyle() {
    return "Modern";
  }
}
