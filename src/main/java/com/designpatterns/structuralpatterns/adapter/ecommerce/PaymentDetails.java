package com.designpatterns.structuralpatterns.adapter.ecommerce;

public class PaymentDetails {
  private String customerName;
  private double amount;
  private String transactionId;

  public PaymentDetails(String customerName, double amount) {
    this.customerName = customerName;
    this.amount = amount;
    this.transactionId = this.generateTransactionId();
  }

  private String generateTransactionId() {
    return "TXN" + System.currentTimeMillis();
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public double getAmount() {
    return this.amount;
  }

  public String getTransactionId() {
    return this.transactionId;
  }
}
