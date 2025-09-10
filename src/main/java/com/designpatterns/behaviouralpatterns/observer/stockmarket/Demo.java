package com.designpatterns.behaviouralpatterns.observer.stockmarket;

public class Demo {
  public static void main(String[] args) {
    Stock appleStock = new Stock("AAPL", 150.0);
    Stock googleStock = new Stock("GOOGL", 2500.0);

    Investor in1 = new Investor("Ramesh");
    Investor in2 = new Investor("Suresh");
    Investor in3 = new Investor("Mahesh");

    appleStock.attach(in1);
    appleStock.attach(in2);
    googleStock.attach(in2);
    googleStock.attach(in3);

    System.out.println("Simulating price changes");
    appleStock.setPrice(155.0);
    googleStock.setPrice(2550.0);

    System.out.println("Unsubscribing an Investor");
    appleStock.detach(in1);

    System.out.println("Another price change");
    appleStock.setPrice(153.0);
  }
}
