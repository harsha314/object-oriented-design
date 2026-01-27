package com.questions.snakeladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Game {
  private List<Move> moves;
  private List<Player> players;

  private Map<String, Integer> currentPosition;
  private int currentPlayer;
  private Dice dice;
  private Board board;

  public Game(Board board, List<Player> players) {
    this.board = board;
    this.players = players;

    this.moves = new ArrayList<>();
    this.currentPlayer = 0;
    this.dice = new Dice();
    this.currentPosition = players.stream().collect(Collectors.toMap(Player::getId, v -> 0));
  }

  public void playTurn() {
    boolean gameEnded = currentPosition.values().stream().anyMatch(position -> position == 100);
    if (gameEnded) {
      System.out.println("The game has ended");
      return;
    }
    int diceValue = dice.throwDice();
    String playerId = players.get(currentPlayer).getId();
    int start = this.currentPosition.getOrDefault(playerId, null);
    int end = board.move(start, diceValue);
    currentPosition.put(playerId, end);
    this.moves.add(new Move(playerId, diceValue));
    findNextPlayer();
  }

  private void findNextPlayer() {
    currentPlayer = (currentPlayer + 1) % (players.size());
  }

}
