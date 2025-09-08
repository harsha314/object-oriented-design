package com.designpatterns.structuralpatterns.flyweight.treerendering;

public class TreeType {
  private final String name;
  private final String texture;
  private final String mesh;

  public TreeType(String name, String texture, String mesh) {
    this.name = name;
    this.texture = texture;
    this.mesh = mesh;
  }

  public void render(int x, int y) {
    System.out.printf("Rendering %s tree at (%d, %d) with texture: %s and mesh: %s%n", this.name, x, y, this.texture,
        this.mesh);
  }

}
