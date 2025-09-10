package com.designpatterns.structuralpatterns.command.texteditor;

public class WriteCommand implements Command {
  private TextEditor editor;
  private String text;
  private int position;

  public WriteCommand(TextEditor editor, String text) {
    this.editor = editor;
    this.text = text;
    this.position = this.editor.getContent().length();
  }

  @Override
  public void execute() {
    this.editor.write(this.text);
  }

  @Override
  public void undo() {
    this.editor.setSelection(this.position, this.position + this.text.length());
    this.editor.deleteSelected();
  }

}
