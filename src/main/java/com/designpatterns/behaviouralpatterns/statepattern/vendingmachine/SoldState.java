package com.designpatterns.behaviouralpatterns.statepattern.vendingmachine;

public class SoldState implements State {
  private VendingMachine vendingMachine;

  public SoldState(VendingMachine vendingMachine) {
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'selectItem'");
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
