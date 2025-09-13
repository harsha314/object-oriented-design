package com.designpatterns.behaviouralpatterns.mediator.flightcontrol;

public class Plane {
  private String id;
  private AirTrafficMediator mediator;
  private boolean isInAir;

  public Plane(String id, AirTrafficMediator mediator) {
    this.id = id;
    this.mediator = mediator;
    this.isInAir = false;
    mediator.registerPlane(this);
  }

  public void requestLanding() {
    if (this.isInAir) {
      System.out.printf("Plane %s : Requesting permission to land%n", this.id);
      mediator.requestLanding(this);
    } else {
      System.out.printf("Plane %s : Already on the ground%n", this.id);
    }
  }

  public void requestTakeoff() {
    if (!isInAir) {
      System.out.printf("Plane %s : Requesting permission to takeoff%n", this.id);
      mediator.requestTakeoff(this);
    } else {
      System.out.printf("Plane %s : Already in the air\n", this.id);
    }
  }

  public void land() {
    this.isInAir = false;
    System.out.printf("Plane %s : Landing completed\n", this.id);
  }

  public void takeoff() {
    this.isInAir = true;
    System.out.printf("Plane %s : Takeoff completed\n", this.id);
  }

  public String getId() {
    return this.id;
  }

}
