package com.designpatterns.creationalpatterns.factory.documentprocessingsystem;

import com.designpatterns.creationalpatterns.factory.documentprocessingsystem.documents.Document;
import com.designpatterns.creationalpatterns.factory.documentprocessingsystem.documents.WordDocument;

public class WordCreator extends DocumentCreator {

  @Override
  public Document createDocument() {
    return new WordDocument();
  }

}
