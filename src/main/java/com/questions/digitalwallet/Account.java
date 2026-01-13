package com.questions.digitalwallet;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Account {
  private String accountId;
  private Map<String, BigDecimal> balances = new ConcurrentHashMap<>();

  public Account(String accountId) {
    this.accountId = accountId;
  }

  public String getAccountId() {
    return accountId;
  }

  public BigDecimal getBalance(String currencyCode) {
    return this.balances.getOrDefault(currencyCode, BigDecimal.ZERO);
  }

  public void addBalance(String currencyCode, BigDecimal amount) {
    this.balances.put(currencyCode, this.getBalance(currencyCode).add(amount));
  }

  public void reduceBalance(String currencyCode, BigDecimal amount) {
    this.balances.put(currencyCode, this.getBalance(currencyCode).subtract(amount));
  }
}
