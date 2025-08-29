package com.designpatterns.structuralpatterns.adapter.ecommerce;

public class PaymentProcessorAdapter implements OldPaymentProcessor {
  private NewGatewayAPI newGateway;

  public PaymentProcessorAdapter(NewGatewayAPI newGateway) {
    this.newGateway = newGateway;
  }

  @Override
  public boolean processPayment(String customerName, double amount) {
    PaymentDetails details = new PaymentDetails(customerName, amount);
    PaymentResult result = newGateway.executePayment(details);
    return result.isSuccess();
  }
}
