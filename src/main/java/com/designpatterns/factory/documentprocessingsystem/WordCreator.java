package com.designpatterns.factory.documentprocessingsystem;

import com.designpatterns.factory.documentprocessingsystem.documents.Document;
import com.designpatterns.factory.documentprocessingsystem.documents.WordDocument;

public class WordCreator extends DocumentCreator {

  @Override
  public Document createDocument() {
    return new WordDocument();
  }

}
