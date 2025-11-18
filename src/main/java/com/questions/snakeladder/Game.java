package com.questions.snakeladder;

public class Game {
  private Board board;
  private Player[] players;
  private RuleEngine ruleEngine;
  private OverflowPolicy overflowPolicy;
  private Dice dice;
  private int currentPlayer;

  public Game(Board board, Player[] players) {
    this.board = board;
    this.players = players;
    this.overflowPolicy = OverflowPolicy.EXACT_WIN;
    this.ruleEngine = new ClassicRuleEngine(this.overflowPolicy);
    this.currentPlayer = 0;
  }

  public void play() {
    int roll = dice.roll();
    Move move = ruleEngine.applyMove(board, players[currentPlayer].getPosition(), roll);
    // Move move = new Move(from, roll, landing, finalCell, null);
    if (ruleEngine.isWin(board, move.finalCell)) {
      System.out.println("Game completed");
      System.out.println("Player " + players[currentPlayer].getName() + " has Won");
      return;
    }
  }
}
