package designpatterns.compositepattern.shapes;

import java.awt.Color;

public class Rectangle extends BaseShape {
  private int height;
  private int width;

  Rectangle(int x, int y, int width, int height, Color color) {
    super(x, y, color);
    this.width = width;
    this.height = height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }
}
