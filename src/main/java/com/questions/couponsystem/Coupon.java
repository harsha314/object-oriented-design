package com.questions.couponsystem;

import java.time.LocalDate;

public abstract class Coupon {
  protected String code;
  protected LocalDate start;
  protected LocalDate end;
  protected double minOrderValue;
  protected int maxUsage;
  protected int userUsageLimit;

  public Coupon(String code, LocalDate start, LocalDate end, double minOrderValue, int maxUsage, int userUsageLimit) {
    this.code = code;
    this.start = start;
    this.end = end;
    this.minOrderValue = minOrderValue;
    this.maxUsage = maxUsage;
    this.userUsageLimit = userUsageLimit;
  }

  public boolean isValid(LocalDate today, double orderValue, int userUsage, int totalUsageCount) {
    if (today.isBefore(start) || today.isAfter(end))
      return false;
    if (minOrderValue > orderValue)
      return false;
    if (maxUsage <= userUsage)
      return false;
    if (userUsageLimit <= totalUsageCount)
      return false;
    return true;
  }

  public abstract double calculateDiscount(double orderValue);

  public String getCode() {
    return code;
  }
}
