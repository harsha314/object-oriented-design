package com.designpatterns.structuralpatterns.adapter.ecommerce;

public interface OldPaymentProcessor {
  boolean processPayment(String customerName, double amount);
}
