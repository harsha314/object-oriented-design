package com.questions.couponsystem;

import java.time.LocalDate;

public class FlatCoupon extends Coupon {

  private double discountAmount;

  public FlatCoupon(String code, LocalDate start, LocalDate end, double minOrderValue, int maxUsage,
      int maxUsageLimit, double discountAmount) {
    super(code, start, end, minOrderValue, maxUsage, maxUsageLimit);
    this.discountAmount = discountAmount;
  }

  public double calculateDiscount(double orderValue) {
    return Math.min(orderValue, discountAmount);
  }
}
