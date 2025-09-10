package com.designpatterns.structuralpatterns.command.texteditor;

public class Demo {
  public static void main(String[] args) {
    TextEditor editor = new TextEditor();
    CommandHistory history = new CommandHistory();

    Command writeCommand = new WriteCommand(editor, "Hello, World!");
    history.executeCommand(writeCommand);
    System.out.printf("After Writing: %s%n", editor.getContent());

    editor.setSelection(0, 5);
    Command copyCommand = new CopyCommand(editor);
    history.executeCommand(copyCommand);
    System.out.printf("Copied Text: %s%n", editor.getClipboard());

    Command pasteCommand = new PasteCommand(editor);
    history.executeCommand(pasteCommand);
    System.out.printf("After paste: %s%n", editor.getContent());

    history.undo();
    System.out.printf("After undo: %s%n", editor.getContent());

    history.redo();
    System.out.printf("After redo: %s\n", editor.getContent());
  }

}
