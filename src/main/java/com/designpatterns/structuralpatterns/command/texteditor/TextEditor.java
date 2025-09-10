package com.designpatterns.structuralpatterns.command.texteditor;

public class TextEditor {
  private StringBuilder content;
  private String clipboard;
  private int selectionStart;
  private int selectionEnd;

  public TextEditor() {
    this.content = new StringBuilder();
    this.clipboard = "";
    this.selectionStart = 0;
    this.selectionEnd = 0;
  }

  public void write(String text) {
    content.append(text);
  }

  public void setSelection(int start, int end) {
    this.selectionStart = Math.min(start, this.content.length());
    this.selectionEnd = Math.min(end, this.content.length());
  }

  public String getSelectedText() {
    return this.content.substring(this.selectionStart, this.selectionEnd);
  }

  public void deleteSelected() {
    this.content.delete(this.selectionStart, this.selectionEnd);
  }

  public void insertText(String text, int position) {
    this.content.insert(position, text);
  }

  public String getContent() {
    return this.content.toString();
  }

  public void setClipboard(String text) {
    this.clipboard = text;
  }

  public String getClipboard() {
    return this.clipboard;
  }
}
