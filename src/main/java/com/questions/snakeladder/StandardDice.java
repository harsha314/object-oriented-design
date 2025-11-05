package com.questions.snakeladder;

import java.util.Random;

public class StandardDice implements Dice {
  private Random random;
  private int bound;

  public StandardDice(int bound) {
    this.random = new Random();
    this.bound = bound;
  }

  public int roll() {
    return 1 + random.nextInt(bound);
  }
}
