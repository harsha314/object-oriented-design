package com.designpatterns.structuralpatterns.adapter.ecommerce;

public interface NewGatewayAPI {
  PaymentResult executePayment(PaymentDetails paymentDetails);
}
