package com.questions.snakeladder.model;

import java.util.Random;

public class Dice {
  Random rand;

  public Dice() {
    this.rand = new Random();
  }

  public Dice(int seed) {
    this.rand = new Random(seed);
  }

  public int throwDice() {
    return rand.nextInt(1, 7);
  }
}
