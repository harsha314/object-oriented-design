package com.questions.snakeladder;

import java.util.ArrayList;
import java.util.List;

public class ClassicRuleEngine implements RuleEngine {

  private OverflowPolicy overflowPolicy;

  public ClassicRuleEngine(OverflowPolicy overflowPolicy) {
    this.overflowPolicy = overflowPolicy;
  }

  @Override
  public Move applyMove(Board board, int currentCell, int roll) {
    int tentative = currentCell + roll;
    List<String> effects = new ArrayList<>();
    int last = board.size();
    int dest = switch (overflowPolicy) {
      case EXACT_WIN -> (tentative > last ? currentCell : tentative);
      case STICK_AT_END -> Math.min(tentative, last);
      case BOUNCE_BACK -> (tentative <= last ? tentative : last - (tentative - last));
    };
    int after = dest;
    while (after >= 1 && after <= last && board.hasPortal(after)) {
      int to = board.portalEnd(after);
      effects.add(to > after ? ("LADDER " + after + "->" + to) : ("SNAKE " + after + "->" + to));
      after = to;
    }
    return new Move(currentCell, roll, dest, after, effects);
  }

  @Override
  public boolean isWin(Board board, int cell) {
    return cell == board.size();
  }
}
