package com.designpatterns.structuralpatterns.composite.filesystem;

public interface FileSystemComponent {
  String getName();

  long getSize();

  void print(String indent);
}
