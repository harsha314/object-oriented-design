package com.questions.splitwise.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Expense {
  private String id;
  private ExpenseType expenseType;
  private BigDecimal amount;
  private String payerId;
  private List<UserShare> shares;

  public Expense(ExpenseType type, String payerId, BigDecimal amount, List<UserShare> shares) {
    this.expenseType = type;
    this.payerId = payerId;
    this.amount = amount;
    this.shares = shares;
  }
}
