package com.questions.splitwise.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UserShare {
  private String userId;
  private BigDecimal amount;
}
