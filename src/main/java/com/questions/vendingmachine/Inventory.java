package com.questions.vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
  Map<Item, Integer> stocks;

  public Inventory() {
    this.stocks = new HashMap<>();
  }

  public void addItem(Item item, int quantity) {
    this.stocks.put(item, this.stocks.getOrDefault(item, 0) + quantity);
  }

  public void dispatch(Item item, int quantity) {

  }

}
