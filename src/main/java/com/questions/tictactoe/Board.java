package com.questions.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
  private Cell[][] board = new Cell[3][3];

  public Board() {
    for (int i = 0; i < 3; ++i)
      for (int j = 0; j < 3; ++j)
        this.board[i][j] = Cell.EMPTY;
  }

  public void setCell(int row, int column, Cell cell) {
    this.board[row][column] = cell;
  }

  public Cell get(int row, int column) {
    return this.board[row][column];
  }

  public boolean checkWinner() {
    if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != Cell.EMPTY)
      return true;
    if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != Cell.EMPTY)
      return true;
    for (int i = 0; i < 3; ++i) {
      if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != Cell.EMPTY)
        return true;
    }
    for (int i = 0; i < 3; ++i) {
      if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != Cell.EMPTY)
        return true;
    }
    return false;
  }

  public boolean checkDraw() {
    if (this.checkWinner())
      return false;
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        if (this.board[i][j] == Cell.EMPTY)
          return false;
      }
    }
    return true;
  }
}
