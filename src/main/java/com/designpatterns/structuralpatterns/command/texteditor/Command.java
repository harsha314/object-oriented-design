package com.designpatterns.structuralpatterns.command.texteditor;

public interface Command {
  void execute();

  void undo();
}
