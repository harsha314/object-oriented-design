package com.designpatterns.structuralpatterns.adapter.ecommerce;

public class Demo {
  public static void main(String[] args) {
    System.out.println("=".repeat(50));
    System.out.println("Legacy Payment System");

    OldPaymentProcessor legacyProcessor = new LegacyPaymentProcessor();
    legacyProcessor.processPayment("John Doe", 100.00);

    System.out.println("=".repeat(50));
    System.out.println("Modern Payment Gateway");

    NewGatewayAPI modernGateway = new ModernPaymentGatewayAPI();
    PaymentDetails details = new PaymentDetails("Jane Smith", 150.00);
    modernGateway.executePayment(details);

    System.out.println("=".repeat(50));
    System.out.println("Using Adapter");
    OldPaymentProcessor adapter = new PaymentProcessorAdapter(modernGateway);
    adapter.processPayment("Bob Wilson", 200.00);
  }
}
