package com.questions.tictactoe;

public class Move {
  private Player player;
  private int row;
  private int column;

  public Move(Player player, int row, int column) {
    this.player = player;
    this.row = row;
    this.column = column;
  }

  public Player getPlayer() {
    return this.player;
  }

  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }
}
