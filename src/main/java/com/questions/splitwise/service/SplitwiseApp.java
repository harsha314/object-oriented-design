package com.questions.splitwise.service;

import java.math.BigDecimal;
import java.util.List;

import com.questions.splitwise.model.Expense;
import com.questions.splitwise.model.ExpenseType;
import com.questions.splitwise.model.Settlement;
import com.questions.splitwise.model.UserShare;

public class SplitwiseApp {

  public Expense createExpense(ExpenseType expenseType, String payerId, BigDecimal amount,
      List<UserShare> contributions) {
    Expense expense = new Expense(expenseType, payerId, amount, contributions);

    return expense;
  }

  public Settlement getSettlementsForUser(String userId) {
    return null;
  }
}
