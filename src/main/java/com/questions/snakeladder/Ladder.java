package com.questions.snakeladder;

public class Ladder {
  private int startCell;
  private int endCell;

  public Ladder(int start, int end) {
    if (start >= end)
      throw new IllegalArgumentException("Ladder must have high end than start");
    this.startCell = start;
    this.endCell = end;
  }

  public int start() {
    return this.startCell;
  }

  public int end() {
    return this.endCell;
  }
}
