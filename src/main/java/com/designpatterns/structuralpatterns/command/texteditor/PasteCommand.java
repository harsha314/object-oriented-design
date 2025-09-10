package com.designpatterns.structuralpatterns.command.texteditor;

public class PasteCommand implements Command {

  /* This PasteCommand always pastes the text in clipboard to the end */

  private TextEditor editor;
  private int position;
  private String pastedText;

  public PasteCommand(TextEditor editor) {
    this.editor = editor;
    this.position = editor.getContent().length();
  }

  @Override
  public void execute() {
    this.pastedText = this.editor.getClipboard();
    this.editor.insertText(this.pastedText, this.position);
  }

  @Override
  public void undo() {
    this.editor.setSelection(this.position, this.position + this.pastedText.length());
    this.editor.deleteSelected();
  }
}
