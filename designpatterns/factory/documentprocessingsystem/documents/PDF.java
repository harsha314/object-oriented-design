package designpatterns.factory.documentprocessingsystem.documents;

public class PDF implements Document {

  @Override
  public void open() {
    System.out.println("Opening PDF Document");
  }

  @Override
  public void save() {
    System.out.println("Saving PDF Document");
  }

  @Override
  public void close() {
    System.out.println("Closing PDF Document");
  }

}
