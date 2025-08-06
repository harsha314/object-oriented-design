package designpatterns.compositepattern.shapes;

import java.awt.Graphics;

public interface Shape {
  public int getX();

  public int getY();

  public int getWidth();

  public int getHeight();

  void move(int x, int y);

  boolean isInsideBounds(int x, int y);

  void select();

  void unselect();

  boolean isSelected();

  void paint(Graphics graphics);
}
