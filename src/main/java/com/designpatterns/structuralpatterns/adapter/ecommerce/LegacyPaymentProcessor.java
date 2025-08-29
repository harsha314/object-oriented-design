package com.designpatterns.structuralpatterns.adapter.ecommerce;

public class LegacyPaymentProcessor implements OldPaymentProcessor {

  @Override
  public boolean processPayment(String customerName, double amount) {
    System.out.println("Processing payment using legacy system");
    System.out.println("Customer: " + customerName);
    System.out.println("Amount: $" + amount);
    return true;
  }
}
