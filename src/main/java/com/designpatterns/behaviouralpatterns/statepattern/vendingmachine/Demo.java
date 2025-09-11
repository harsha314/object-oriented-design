package com.designpatterns.behaviouralpatterns.statepattern.vendingmachine;

public class Demo {
  public static void main(String[] args) {
    VendingMachine vendingMachine = new VendingMachine(2);

    System.out.println("=".repeat(50));
    System.out.println("Test 1: Normal Purchase");
    vendingMachine.insertCoin();
    vendingMachine.selectItem();
    // System.out.println("=".repeat(50));

    System.out.println("=".repeat(50));
    System.out.println("Test 2: No Coin Selection");
    vendingMachine.selectItem();
    // System.out.println("=".repeat(50));

    System.out.println("=".repeat(50));
    System.out.println("Test 3: Complete Purchase");
    vendingMachine.insertCoin();
    vendingMachine.selectItem();
    // System.out.println("=".repeat(50));

    System.out.println("=".repeat(50));
    System.out.println("Test 4: Sold Out State");
    vendingMachine.insertCoin();
    vendingMachine.selectItem();
    System.out.println("=".repeat(50));

  }

}
