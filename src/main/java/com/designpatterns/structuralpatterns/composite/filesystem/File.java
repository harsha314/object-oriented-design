package com.designpatterns.structuralpatterns.composite.filesystem;

public class File implements FileSystemComponent {
  private String name;
  private long size;

  public File(String name, long size) {
    this.name = name;
    this.size = size;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public long getSize() {
    return this.size;
  }

  @Override
  public void print(String indent) {
    System.out.println(String.format("%s %s %d bytes", indent, this.name, this.size));
  }
}
