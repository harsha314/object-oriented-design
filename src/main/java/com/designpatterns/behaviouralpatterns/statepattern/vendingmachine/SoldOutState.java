package com.designpatterns.behaviouralpatterns.statepattern.vendingmachine;

public class SoldOutState {
  private VendingMachine vendingMachine;

  public SoldOutState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }
}
