package com.designpatterns.creationalpatterns.factory.documentprocessingsystem;

import com.designpatterns.creationalpatterns.factory.documentprocessingsystem.documents.Document;
import com.designpatterns.creationalpatterns.factory.documentprocessingsystem.documents.PDF;

public class PdfCreator extends DocumentCreator {
  public Document createDocument() {
    return new PDF();
  }
}
