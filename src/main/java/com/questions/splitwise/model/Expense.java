package com.questions.splitwise.model;

import java.math.BigDecimal;
import java.util.Map;

import lombok.Data;

@Data
public class Expense {
  private ExpenseType expenseType;

  public Expense(ExpenseType type) {
    this.expenseType = type;
  }
}
