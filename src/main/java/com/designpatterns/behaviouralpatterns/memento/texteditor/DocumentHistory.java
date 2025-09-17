package com.designpatterns.behaviouralpatterns.memento.texteditor;

import java.util.ArrayList;
import java.util.List;

public class DocumentHistory {
  private final List<DocumentMemento> history;
  private int currentIndex;

  public DocumentHistory() {
    this.history = new ArrayList<>();
    this.currentIndex = -1;
  }

  public void save(Document document) {
    while (this.history.size() > currentIndex + 1) {
      history.remove(this.history.size() - 1);
    }

    history.add(document.save());
    ++currentIndex;
    System.out.println("Saved document state " + (currentIndex + 1));
  }

  public void undo(Document document) {
    if (currentIndex > 0) {
      --currentIndex;
      document.restore(history.get(currentIndex));
      System.out.println("Undo to state " + (this.currentIndex + 1));
    } else {
      System.out.println("Cannot undo: At earliest state");
    }
  }

  public void redo(Document document) {
    if (this.currentIndex < this.history.size() - 1) {
      ++this.currentIndex;
      document.restore(this.history.get(this.currentIndex));
      System.out.println("Redo to state " + (this.currentIndex + 1));
    } else {
      System.out.println("Cannot redo: At latest state");
    }
  }
}
