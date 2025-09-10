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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'ejectCoin'");
  }

  @Override
  public void selectItem() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'selectItem'");
  }

  @Override
  public void dispense() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'dispense'");
  }

}
