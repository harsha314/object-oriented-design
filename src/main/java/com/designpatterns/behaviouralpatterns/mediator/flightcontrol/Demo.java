package com.designpatterns.behaviouralpatterns.mediator.flightcontrol;

public class Demo {
  public static void main(String[] args) {
    AirTrafficMediator controlTower = new ControlTower();

    Plane plane1 = new Plane("A1", controlTower);
    Plane plane2 = new Plane("A2", controlTower);
    Plane plane3 = new Plane("A3", controlTower);

    System.out.println("=".repeat(50));
    System.out.println("Testing Takeoff sequence");
    plane1.requestTakeoff();
    plane2.requestTakeoff();

    System.out.println("=".repeat(50));
    System.out.println("Testing Landing Sequence");
    plane1.requestLanding();
    plane3.requestTakeoff();

    System.out.println("=".repeat(50));
    System.out.println("Testing Invalid Operations");
    plane1.requestTakeoff();
    plane2.requestLanding();
    System.out.println("=".repeat(50));
  }
}
