package com.questions.tictactoe;

import java.util.Scanner;

public class Demo {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Player player1 = new Player("John");
    Player player2 = new Player("Jane");
    Game game = new Game("John", "Jane");
    while (game.getStatus() == GameStatus.INPROGRESS) {
      System.out.println("It is " + game.getCurrentPlayer() + "'s turn, Enter row and column: ");
      int row = scanner.nextInt(), column = scanner.nextInt();
      game.makeMove(row, column);
    }
  }
}
