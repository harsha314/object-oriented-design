package com.designpatterns.factory.documentprocessingsystem;

import com.designpatterns.factory.documentprocessingsystem.documents.Document;
import com.designpatterns.factory.documentprocessingsystem.documents.PDF;

public class PdfCreator extends DocumentCreator {
  public Document createDocument() {
    return new PDF();
  }
}
