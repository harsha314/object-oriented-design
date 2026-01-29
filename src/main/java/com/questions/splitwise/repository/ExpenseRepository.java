package com.questions.splitwise.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.questions.splitwise.model.Expense;
import com.questions.splitwise.model.Settlement;

public class ExpenseRepository {
  private Map<String, Expense> data = new HashMap<>();

  public Expense addExpense(Expense expense) {
    data.put(expense.getId(), expense);
    return null;
  }

  public Settlement getSettlementsForUser(String userId) {
    BigDecimal paid = data.values().stream().map(Expense::getAmount).reduce(BigDecimal::add).get();
    return null;
  }
}
