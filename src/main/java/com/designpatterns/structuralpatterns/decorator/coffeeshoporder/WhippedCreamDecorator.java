package com.designpatterns.structuralpatterns.decorator.coffeeshoporder;

public class WhippedCreamDecorator extends CoffeeDecorator {
  public WhippedCreamDecorator(Coffee coffee) {
    super(coffee);
  }

  @Override
  public double getCost() {
    return super.getCost() + 0.7;
  }

  @Override
  public String getDescription() {
    return super.getDescription() + ", Whipped cream";
  }
}
