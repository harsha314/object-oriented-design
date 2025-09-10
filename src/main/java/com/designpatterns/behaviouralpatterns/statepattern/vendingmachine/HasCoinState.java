package com.designpatterns.behaviouralpatterns.statepattern.vendingmachine;

public class HasCoinState implements State {
  private VendingMachine vendingMachine;

  public HasCoinState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void insertCoin() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insertCoin'");
  }

  @Override
  public void ejectCoin() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'ejectCoin'");
  }

  @Override
  public void selectItem() {
    System.out.println("Item selected");
    this.vendingMachine.setState(this.vendingMachine.getSoldState());
  }

  @Override
  public void dispense() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'dispense'");
  }
}
