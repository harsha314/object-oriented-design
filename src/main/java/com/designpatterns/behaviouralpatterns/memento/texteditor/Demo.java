package com.designpatterns.behaviouralpatterns.memento.texteditor;

public class Demo {
  public static void main(String[] args) {
    Document document = new Document();

    DocumentHistory history = new DocumentHistory();

    history.save(document);

    document.write("Hello ");
    history.save(document);

    document.write("World!");
    history.save(document);

    document.setCursor(6);
    document.write("Beautiful ");
    history.save(document);

    System.out.println("Final content : " + document.getContent());

    System.out.println("=".repeat(50));
    System.out.println("Testing undo operations:");
    history.undo(document);
    history.undo(document);

    System.out.println("=".repeat(50));
    System.out.println("Testing redo operations");
    history.redo(document);

    System.out.println("=".repeat(50));
    System.out.println("Making new changes after undo:");
    document.write("Amazing ");
    history.save(document);

    System.out.println("=".repeat(50));
    System.out.println("Trying to redo after new changes:");
    history.redo(document);
  }
}
