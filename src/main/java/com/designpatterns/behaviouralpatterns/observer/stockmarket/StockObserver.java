package com.designpatterns.behaviouralpatterns.observer.stockmarket;

public interface StockObserver {
  void update(String stockSymbol, double price);
}
