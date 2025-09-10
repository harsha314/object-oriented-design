package com.designpatterns.behaviouralpatterns.statepattern.vendingmachine;

public interface State {
  void insertCoin();

  void ejectCoin();

  void selectItem();

  void dispense();
}
