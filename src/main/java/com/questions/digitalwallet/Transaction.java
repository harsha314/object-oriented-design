package com.questions.digitalwallet;

import java.math.BigDecimal;

public class Transaction {
  private Account senderAccount;
  private Account receiverAccount;
  private BigDecimal amount;
  private String currencyCode;

  public Transaction(Account senderAccount, Account receiverAccount, BigDecimal amount, String currencyCode) {
    this.senderAccount = senderAccount;
    this.receiverAccount = receiverAccount;
    this.amount = amount;
    this.currencyCode = currencyCode;
  }

  public boolean isValid() {
    if (this.senderAccount == null || this.receiverAccount == null)
      return false;
    if (this.senderAccount.getBalance(currencyCode).compareTo(amount) < 0)
      return false;
    return true;
  }

  public boolean execute() {
    if (!isValid()) {
      return false;
    }
    synchronized (this.receiverAccount) {
      synchronized (this.senderAccount) {
        this.senderAccount.reduceBalance(currencyCode, amount);
        this.receiverAccount.reduceBalance(currencyCode, amount);
      }
    }
    return true;
  }

  public Account getSenderAccount() {
    return this.senderAccount;
  }

  public Account getReceiverAccount() {
    return this.receiverAccount;
  }

  public BigDecimal getAmount() {
    return this.amount;
  }
}
