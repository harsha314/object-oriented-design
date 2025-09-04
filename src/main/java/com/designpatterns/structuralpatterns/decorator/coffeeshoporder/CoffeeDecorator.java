package com.designpatterns.structuralpatterns.decorator.coffeeshoporder;

public abstract class CoffeeDecorator implements Coffee {
  protected Coffee decoratedCoffee;

  public CoffeeDecorator(Coffee coffee) {
    this.decoratedCoffee = coffee;
  }

  @Override
  public double getCost() {
    return this.decoratedCoffee.getCost();
  }

  @Override
  public String getDescription() {
    return this.decoratedCoffee.getDescription();
  }

}
