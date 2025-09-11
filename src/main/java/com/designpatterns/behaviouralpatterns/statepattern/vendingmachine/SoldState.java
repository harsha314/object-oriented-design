package com.designpatterns.behaviouralpatterns.statepattern.vendingmachine;

public class SoldState implements State {
  private VendingMachine vendingMachine;

  public SoldState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void insertCoin() {
    System.out.println("Please wait, item being dispensed");
  }

  @Override
  public void ejectCoin() {
    System.out.println("Sorry, item already being dispensed");
  }

  @Override
  public void selectItem() {
    System.out.println("Please wait, item being dispensed");
  }

  @Override
  public void dispense() {
    this.vendingMachine.releaseItem();
    if (this.vendingMachine.getCount() > 0) {
      this.vendingMachine.setState(this.vendingMachine.getNoCoinState());
    } else {
      this.vendingMachine.setState(this.vendingMachine.getSoldOutState());
    }
  }
}
