package com.designpatterns.structuralpatterns.adapter.ecommerce;

public class PaymentResult {
  private boolean success;
  private String transactionId;

  public PaymentResult(boolean success, String transactionId) {
    this.success = success;
    this.transactionId = transactionId;
  }

  public boolean isSuccess() {
    return this.success;
  }

  public String getTransactionId() {
    return this.transactionId;
  }
}
