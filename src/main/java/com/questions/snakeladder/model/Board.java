package com.questions.snakeladder.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Board {
  private Map<Integer, Snake> snakesMap;
  private Map<Integer, Ladder> laddersMap;

  public Board(Snake[] snakes, Ladder[] ladders) {
    this.snakesMap = Arrays.stream(snakes).collect(Collectors.toMap(Snake::getStart, Function.identity()));
    this.laddersMap = Arrays.stream(ladders).collect(Collectors.toMap(Ladder::getStart, Function.identity()));
  }

  public int move(int start, int diceValue) {
    start = start + diceValue > 100 ? start : start + diceValue;
    do {
      Snake snake = this.snakesMap.getOrDefault(start, null);
      Ladder ladder = this.laddersMap.getOrDefault(start, null);
      if (snake != null) {
        start = snake.getEnd();
      } else if (ladder != null) {
        start = ladder.getEnd();
      } else {
        return start;
      }
    } while (true);
  }
}
