package com.questions.snakeladder;

import java.util.List;

public class Board {
  private int cells;
  private List<Portal> portals;
  private List<Player> players;

  public Board(int cells, List<Portal> portals, List<Player> players) {
    this.cells = cells;
    this.portals = portals;
    this.players = players;
  }
}
