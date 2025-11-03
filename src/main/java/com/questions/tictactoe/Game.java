package com.questions.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Game {
  private GameStatus status;
  private List<Move> moves;
  private Board board;
  private Player player1;
  private Player player2;
  private Player currentPlayer;

  public Game(String player1, String player2) {
    this.status = GameStatus.INPROGRESS;
    this.moves = new ArrayList<>();
    this.player1 = new Player(player1);
    this.player2 = new Player(player2);
    this.currentPlayer = this.player1;
    this.board = new Board();
  }

  public void makeMove(int row, int col) {
    if (this.status == GameStatus.COMPLETED) {
      System.out.println("This Game has been completed," + this.currentPlayer.getName() + " has won");
      return;
    }
    if (this.status == GameStatus.DRAW) {
      System.out.println("It was a draw");
      return;
    }
    if (this.board.get(row, col) != Cell.EMPTY) {
      System.out.println("Illegal move, choose a valid square to make a move");
    }

    if (this.currentPlayer.equals(this.player1))
      this.board.setCell(row, col, Cell.PLAYER1);
    else
      this.board.setCell(row, col, Cell.PLAYER2);
    if (this.checkWinner()) {
      System.out.println("This Game has been completed," + this.currentPlayer.getName() + " has won");
      return;
    }
    if (this.checkDraw()) {
      this.status = GameStatus.DRAW;
      System.out.println("It was a draw");
      return;
    }
    this.switchPlayer();
  }

  public GameStatus getStatus() {
    return this.status;
  }

  private boolean checkWinner() {
    return this.board.checkWinner();
  }

  private boolean checkDraw() {
    return this.board.checkDraw();
  }

  private void switchPlayer() {
    this.currentPlayer = this.currentPlayer.equals(this.player1) ? this.player2 : this.player2;
  }

  public String getCurrentPlayer() {
    return this.currentPlayer.getName();
  }
}
