package com.questions.snakeladder;

public interface RuleEngine {
  Move applyMove(Board board, int currentCell, int roll);

  boolean isWin(Board board, int cell);
}
