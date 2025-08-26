package com.designpatterns.creationalpatterns.factory.documentprocessingsystem;

import java.util.Collections;

public class Demo {
  public static void main(String[] args) {
    DocumentCreator pdfCreator = new PdfCreator();
    DocumentCreator wordCreator = new WordCreator();

    System.out.println("Processing PDF Document");
    pdfCreator.processDocument();

    System.out.println(String.join("", Collections.nCopies(50, "*")));

    System.out.println("Processing Word Document");
    wordCreator.processDocument();
    ;
  }
}
