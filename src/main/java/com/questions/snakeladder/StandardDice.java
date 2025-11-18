package com.questions.snakeladder;

import java.util.Random;

public class StandardDice implements Dice {
  private Random random;
  private int bound;

  public StandardDice(int bound) {
    this.random = new Random();
    this.bound = bound;
  }

  public StandardDice(int bound, int seed) {
    this(bound);
    this.random = new Random(seed);
  }

  public int roll() {
    return 1 + random.nextInt(bound);
  }
}
