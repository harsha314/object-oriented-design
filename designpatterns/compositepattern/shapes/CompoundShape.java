package designpatterns.compositepattern.shapes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundShape extends BaseShape {
  private List<Shape> children;

  CompoundShape(int x, int y, Color color, Shape... components) {
    super(x, y, color);
    this.children = new ArrayList<>();
  }

  public void add(Shape component) {
    this.children.add(component);
  }

  public void add(Shape... components) {
    this.children.addAll(Arrays.asList(components));
  }

  public void remove(Shape shape) {
    this.children.remove(shape);
  }

  public void remove(Shape... components) {
    this.children.removeAll(Arrays.asList(components));
  }

  @Override
  public int getX() {
    if (this.children.size() == 0) {
      return this.x;
    }
    return 0;
  }
}
