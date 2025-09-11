package com.designpatterns.behaviouralpatterns.statepattern.vendingmachine;

public class SoldOutState implements State {
  private VendingMachine vendingMachine;

  public SoldOutState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void insertCoin() {
    System.out.println("Items are sold out");
  }

  @Override
  public void ejectCoin() {
    System.out.println("Cannot eject, no coin inserted");
  }

  @Override
  public void selectItem() {
    System.out.println("Items are sold out");
  }

  @Override
  public void dispense() {
    System.out.println("No items to dispense");
  }
}
