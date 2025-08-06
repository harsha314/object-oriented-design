package designpatterns.compositepattern.shapes;

import java.awt.Color;

public class Circle extends BaseShape {

  private int radius;

  Circle(int x, int y, int radius, Color color) {
    super(x, y, color);
    this.radius = radius;
  }

  @Override
  public int getWidth() {
    return this.radius * 2;
  }

  @Override
  public int getHeight() {
    return this.radius * 2;
  }

}
