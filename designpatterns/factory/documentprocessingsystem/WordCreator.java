package designpatterns.factory.documentprocessingsystem;

import designpatterns.factory.documentprocessingsystem.documents.Document;
import designpatterns.factory.documentprocessingsystem.documents.WordDocument;

public class WordCreator extends DocumentCreator {

  @Override
  public Document createDocument() {
    return new WordDocument();
  }

}
