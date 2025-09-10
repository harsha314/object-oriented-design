package com.designpatterns.behaviouralpatterns.statepattern.vendingmachine;

public class VendingMachine {
  private State noCoinState;
  private State hasCoinState;
  private State soldState;
  private State soldOutState;

  private State currentState;
  private int count;

  public VendingMachine(int itemCount) {
    this.noCoinState = new NoCoinState(this);
    // this.hasCoinState = new HasCoinState(this);
    // this.soldState = new SoldState(this);
    // this.soldOutState = new SoldOutState(this);

    this.count = itemCount;
    this.currentState = this.noCoinState;
  }

  public void insertCoin() {
    this.currentState.insertCoin();
  }

  public void ejectCoin() {
    this.currentState.ejectCoin();
  }

  public void selectItem() {
    this.currentState.selectItem();
    this.currentState.dispense();
  }

  public void setState(State state) {
    this.currentState = state;
  }

  public void releaseItem() {
    if (this.count > 0) {
      --this.count;
      System.out.println("Item dispensed");
    }
  }

  public State getNoCoinState() {
    return this.noCoinState;
  }

  public State getHasCoinState() {
    return this.hasCoinState;
  }

  public State getSoldState() {
    return this.soldState;
  }

  public State getSoldOutState() {
    return this.soldOutState;
  }

  public int getCount() {
    return this.count;
  }
}
