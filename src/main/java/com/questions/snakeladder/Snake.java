package com.questions.snakeladder;

public class Snake implements Portal {
  private int startCell;
  private int endCell;

  public Snake(int start, int end) {
    if (start <= end)
      throw new IllegalArgumentException("Snake must have start higher than end");
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
