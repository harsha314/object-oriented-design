package com.designpatterns.creationalpatterns.factory.documentprocessingsystem;

import com.designpatterns.creationalpatterns.factory.documentprocessingsystem.documents.Document;

public abstract class DocumentCreator {
  public abstract Document createDocument();

  public final void processDocument() {
    Document document = createDocument();
    document.open();
    document.save();
    document.close();
  }
}
