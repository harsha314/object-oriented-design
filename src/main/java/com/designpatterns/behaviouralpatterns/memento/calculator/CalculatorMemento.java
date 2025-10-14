package com.designpatterns.behaviouralpatterns.memento.calculator;

public class CalculatorMemento {
  private final double value;
  private final String currentOperation;

  public CalculatorMemento(double value, String currentOperations) {
    this.value = value;
    this.currentOperation = currentOperations;
  }

  public double getValue() {
    return this.value;
  }

  public String getCurrentOperation() {
    return this.currentOperation;
  }
}
