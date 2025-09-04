package com.designpatterns.structuralpatterns.decorator.coffeeshoporder;

public class Demo {
  public static void main(String[] args) {
    Coffee coffee1 = new MilkDecorator(new BasicCoffee());
    System.out.println("=".repeat(50));
    System.out.println("Order 1:");
    System.out.println("Description : " + coffee1.getDescription());
    System.out.println("Cost: $" + coffee1.getCost());
    System.out.println("=".repeat(50));

    Coffee coffee2 = new SugarDecorator(new MilkDecorator(new BasicCoffee()));
    System.out.println("Order 2:");
    System.out.println("Description : " + coffee2.getDescription());
    System.out.println("Cost: $" + coffee2.getCost());
    System.out.println("=".repeat(50));

    Coffee coffee3 = new WhippedCreamDecorator(new SugarDecorator(new MilkDecorator((new BasicCoffee()))));
    System.out.println("Order 3:");
    System.out.println("Description : " + coffee3.getDescription());
    System.out.println("Cost: $" + coffee3.getCost());
    System.out.println("=".repeat(50));

  }
}
