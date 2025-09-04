package com.designpatterns.structuralpatterns.composite.filesystem;

public class Demo {
  public static void main(String[] args) {
    Directory root = new Directory("root");

    // Create some files and add them to root
    root.add(new File("readme.txt", 100));
    root.add(new File("license.md", 200));

    // Create a subdirectory with files
    Directory docs = new Directory("docs");
    docs.add(new File("manual.pdf", 500));
    docs.add(new File("guide.doc", 300));

    // Create another level of directory
    Directory images = new Directory("images");
    images.add(new File("photo1.jpg", 1024));
    images.add(new File("photo2.jpg", 2048));

    // Add directories to the hierarchy
    docs.add(images);
    root.add(docs);

    // Print the entire file system
    System.out.println("File System Structure:");
    root.print("");

    // Get size of specific components
    System.out.println("\nSize Information:");
    System.out.println("Size of root: " + root.getSize() + " bytes");
    System.out.println("Size of docs: " + docs.getSize() + " bytes");
    System.out.println("Size of images: " + images.getSize() + " bytes");

  }
}
