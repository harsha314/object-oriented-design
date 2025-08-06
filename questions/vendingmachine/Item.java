package questions.vendingmachine;

public class Item {
  String name;
  double cost;

  public Item(String name, double cost) {
    this.name = name;
    this.cost = cost;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getCost() {
    return this.cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }
}
