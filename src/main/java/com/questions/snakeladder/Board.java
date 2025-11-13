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

  public int size() {
    return this.cells;
  }

  public boolean hasPortal(int cell) {
    for (Portal p : portals) {
      if (p.start() == cell)
        return true;
    }
    return false;
  }

  public int portalEnd(int cell) {
    for (Portal p : portals) {
      if (p.start() == cell) {
        return p.end();
      }
    }
    return -1;
  }
}
