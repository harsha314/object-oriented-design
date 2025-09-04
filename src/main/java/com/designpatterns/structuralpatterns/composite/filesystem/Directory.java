package com.designpatterns.structuralpatterns.composite.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
  private String name;
  private List<FileSystemComponent> components;

  public Directory(String name) {
    this.name = name;
    this.components = new ArrayList<>();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public long getSize() {
    long size = 0;
    for (FileSystemComponent component : this.components) {
      size += component.getSize();
    }
    return size;
  }

  public void add(FileSystemComponent component) {
    this.components.add(component);
  }

  public void remove(FileSystemComponent component) {
    this.components.remove(component);
  }

  @Override
  public void print(String indent) {
    System.out.println(String.format("%s dir : %s (%d bytes)", indent, this.name, this.getSize()));
    for (FileSystemComponent component : this.components) {
      component.print(indent + "  ");
    }
  }
}
