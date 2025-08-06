package designpatterns.compositepattern.shapes;

import java.awt.Color;

public class Dot extends BaseShape {

  private final int DOT_SIZE = 3;

  Dot(int x, int y, Color color) {
    super(x, y, color);
  }

  @Override
  public int getWidth() {
    return this.DOT_SIZE;
  }

  @Override
  public int getHeight() {
    return this.DOT_SIZE;
  }

}
