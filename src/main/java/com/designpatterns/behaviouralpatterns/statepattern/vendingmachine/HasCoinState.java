package com.designpatterns.behaviouralpatterns.statepattern.vendingmachine;

public class HasCoinState implements State {
  private VendingMachine vendingMachine;

  public HasCoinState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void insertCoin() {
    System.out.println("Coin already inserted");
  }

  @Override
  public void ejectCoin() {
    System.out.println("Coin returned");
    this.vendingMachine.setState(this.vendingMachine.getNoCoinState());
  }

  @Override
  public void selectItem() {
    System.out.println("Item selected");
    this.vendingMachine.setState(this.vendingMachine.getSoldState());
  }

  @Override
  public void dispense() {
    System.out.println("Please select an item first");
  }
}
