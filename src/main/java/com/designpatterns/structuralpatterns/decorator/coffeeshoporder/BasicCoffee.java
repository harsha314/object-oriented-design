package com.designpatterns.structuralpatterns.decorator.coffeeshoporder;

public class BasicCoffee implements Coffee {
  @Override
  public double getCost() {
    return 2.0;
  }

  @Override
  public String getDescription() {
    return "Basic Coffee";
  }
}
