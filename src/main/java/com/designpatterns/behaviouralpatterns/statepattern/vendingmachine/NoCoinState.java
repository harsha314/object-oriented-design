package com.designpatterns.behaviouralpatterns.statepattern.vendingmachine;

public class NoCoinState implements State {

  private VendingMachine vendingMachine;

  public NoCoinState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void insertCoin() {
    System.out.println("Coin inserted");
    this.vendingMachine.setState(this.vendingMachine.getHasCoinState());
  }

  @Override
  public void ejectCoin() {
    System.out.println("No coin to eject");
  }

  @Override
  public void selectItem() {
    System.out.println("Please insert a coin first");
  }

  @Override
  public void dispense() {
    System.out.println("Please insert a coin first");
  }

}
