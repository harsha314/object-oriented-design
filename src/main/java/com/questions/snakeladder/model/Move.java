package com.questions.snakeladder.model;

public class Move {
  private String playerId;
  private int diceValue;

  public Move(String playerId, int diceValue) {
    this.playerId = playerId;
    this.diceValue = diceValue;
  }

  public String getPlayerId() {
    return this.playerId;
  }

  public int getDiceValue() {
    return this.diceValue;
  }
}
