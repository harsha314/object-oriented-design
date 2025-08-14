package designpatterns.factory.documentprocessingsystem.documents;

public interface Document {
  void open();

  void save();

  void close();
}
