package com.designpatterns.behaviouralpatterns.memento.texteditor;

public class DocumentMemento {
  private final String content;
  private final int cursorPosition;
  private final long timestamp;

  public DocumentMemento(String content, int cursorPosition) {
    this.content = content;
    this.cursorPosition = cursorPosition;
    this.timestamp = System.currentTimeMillis();
  }

  public String getContent() {
    return this.content;
  }

  public int getCursorPosition() {
    return this.cursorPosition;
  }

  public long getTimestamp() {
    return this.timestamp;
  }
}
