package com.questions.snakeladder;

import java.util.List;

public class Move {
  int from, roll, landing, finalCell;
  List<String> effects;

  public Move(int from, int roll, int landing, int finalCell, List<String> effects) {
    this.from = from;
    this.roll = roll;
    this.landing = landing;
    this.finalCell = finalCell;
    this.effects = effects;
  }

  // public
}