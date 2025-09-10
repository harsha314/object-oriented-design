package com.designpatterns.structuralpatterns.command.texteditor;

import java.util.Stack;

public class CommandHistory {
  private Stack<Command> undoStack = new Stack<>();
  private Stack<Command> redoStack = new Stack<>();

  public void executeCommand(Command command) {
    command.execute();
    this.undoStack.push(command);
    this.redoStack.clear();
  }

  public void undo() {
    if (!this.undoStack.empty()) {
      Command command = this.undoStack.pop();
      command.undo();
      this.redoStack.push(command);
    }
  }

  public void redo() {
    if (!this.redoStack.empty()) {
      Command command = redoStack.pop();
      command.execute();
      undoStack.push(command);
    }
  }

}
