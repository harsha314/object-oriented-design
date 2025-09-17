package com.designpatterns.behaviouralpatterns.memento.texteditor;

public class Document {
  private String content;
  private int cursorPosition;

  public Document() {
    this.content = "";
    this.cursorPosition = 0;
  }

  public void write(String text) {
    StringBuilder sb = new StringBuilder(content);
    sb.insert(this.cursorPosition, text);
    this.content = sb.toString();
    cursorPosition += text.length();
    System.out.println("Writing: " + text);
  }

  public void delete(int chars) {
    if (this.cursorPosition >= chars) {
      StringBuilder sb = new StringBuilder(content);
      sb.delete(this.cursorPosition - chars, this.cursorPosition);
      this.content = sb.toString();
      this.cursorPosition -= chars;
      System.out.println("Deleting " + chars + " characters");
    }
  }

  public void setCursor(int position) {
    this.cursorPosition = Math.min(position, content.length());
    this.cursorPosition = Math.max(0, this.cursorPosition);
  }

  public DocumentMemento save() {
    return new DocumentMemento(content, cursorPosition);
  }

  public void restore(DocumentMemento memento) {
    this.content = memento.getContent();
    this.cursorPosition = memento.getCursorPosition();
    System.out.println("Restored to: " + this.content);
  }

  public String getContent() {
    return this.content;
  }

  public int getCursorPosition() {
    return this.cursorPosition;
  }
}
