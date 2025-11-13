package com.questions.snakeladder;

public class Ladder implements Portal {
  private int startCell;
  private int endCell;

  public Ladder(int start, int end) {
    if (start >= end)
      throw new IllegalArgumentException("Ladder must have high end than start");
    this.startCell = start;
    this.endCell = end;
  }

  @Override
  public int start() {
    return this.startCell;
  }

  @Override
  public int end() {
    return this.endCell;
  }
}
