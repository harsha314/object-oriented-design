package com.designpatterns.behaviouralpatterns.observer.stockmarket;

public class Investor implements StockObserver {
  private String name;

  public Investor(String name) {
    this.name = name;
  }

  @Override
  public void update(String stockSymbol, double price) {
    System.out.printf("Notification to %s: %s stock price changed to %.2f%n", name, stockSymbol, price);
  }
}
