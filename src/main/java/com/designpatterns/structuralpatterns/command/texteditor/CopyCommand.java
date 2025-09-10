package com.designpatterns.structuralpatterns.command.texteditor;

public class CopyCommand implements Command {
  private TextEditor editor;
  private String previousClipboard;

  public CopyCommand(TextEditor editor) {
    this.editor = editor;
  }

  @Override
  public void execute() {
    this.previousClipboard = this.editor.getClipboard();
    this.editor.setClipboard(this.editor.getSelectedText());
  }

  @Override
  public void undo() {
    this.editor.setClipboard(this.previousClipboard);
  }
}
