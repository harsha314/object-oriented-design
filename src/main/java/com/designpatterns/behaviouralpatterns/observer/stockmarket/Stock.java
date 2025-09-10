package com.designpatterns.behaviouralpatterns.observer.stockmarket;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {
  private String symbol;
  private double price;
  private List<StockObserver> observers;

  public Stock(String symbol, double price) {
    this.symbol = symbol;
    this.price = price;
    this.observers = new ArrayList<>();
  }

  @Override
  public void attach(StockObserver observer) {
    this.observers.add(observer);
    System.out.println("Observer added for " + symbol);
  }

  @Override
  public void detach(StockObserver observer) {
    observers.remove(observer);
    System.out.println("Observer removed for " + symbol);
  }

  @Override
  public void notifyObservers() {
    observers.forEach(observer -> {
      observer.update(symbol, price);
    });
  }

  public void setPrice(double newPrice) {
    if (this.price != newPrice) {
      System.out.println("Stock price changed for " + symbol);
      this.price = newPrice;
      notifyObservers();
    }
  }

  public double getPrice() {
    return this.price;
  }

  public String getSymbol() {
    return this.symbol;
  }
}
