package com.questions.couponsystem;

import java.time.LocalDate;

public class PercentageCoupon extends Coupon {

  private double percentage;

  public PercentageCoupon(String code, LocalDate start, LocalDate end, double minOrderValue, int maxUsage,
      int maxUsageLimit, double percentage) {
    super(code, start, end, minOrderValue, maxUsage, maxUsageLimit);
    this.percentage = percentage;
  }

  public double calculateDiscount(double orderValue) {
    return orderValue * 0.01 * percentage;
  }
}
