package designpatterns.compositepattern.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class BaseShape implements Shape {

  public int x;
  public int y;
  public Color color;
  private boolean selected = false;

  BaseShape(int x, int y, Color color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public int getWidth() {
    return 0;
  }

  @Override
  public int getHeight() {
    return 0;
  }

  @Override
  public void move(int x, int y) {
    this.x += x;
    this.y += y;
  }

  @Override
  public boolean isInsideBounds(int x, int y) {
    return x > this.getX() && x < this.getX() + this.getWidth() && y > this.getY()
        && y < this.getY() + this.getHeight();
  }

  @Override
  public void select() {
    this.selected = true;
  }

  @Override
  public void unselect() {
    this.selected = false;
  }

  @Override
  public boolean isSelected() {
    return this.selected;
  }

  @Override
  public void paint(Graphics graphics) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'paint'");
  }

}
