package com.designpatterns.structuralpatterns.adapter.ecommerce;

public class ModernPaymentGatewayAPI implements NewGatewayAPI {
  public PaymentResult executePayment(PaymentDetails paymentDetails) {
    System.out.println("Processing payment using modern payment gateway");
    System.out.println("Transaction ID : " + paymentDetails.getTransactionId());
    System.out.println("Customer : " + paymentDetails.getCustomerName());
    System.out.println("Amount: $" + paymentDetails.getAmount());
    return new PaymentResult(true, paymentDetails.getTransactionId());
  }
}
