package com.designpatterns.behaviouralpatterns.observer.stockmarket;

public interface Subject {
  void attach(StockObserver observer);

  void detach(StockObserver observer);

  void notifyObservers();
}
