package com.designpatterns.behaviouralpatterns.mediator.flightcontrol;

import java.util.ArrayList;
import java.util.List;

public class ControlTower implements AirTrafficMediator {
  private List<Plane> registeredPlanes;
  private boolean runwayClear;

  public ControlTower() {
    this.registeredPlanes = new ArrayList<>();
    this.runwayClear = true;
  }

  @Override
  public void registerPlane(Plane plane) {
    this.registeredPlanes.add(plane);
    System.out.printf("Control Tower: Plane %s has been registered%n", plane.getId());
  }

  @Override
  public void requestLanding(Plane plane) {
    if (this.runwayClear) {
      this.runwayClear = false;
      System.out.printf("Control Tower: Landing Permission granted to Plane %s%n", plane.getId());
      plane.land();
      this.runwayClear = true;
    } else {
      System.out.printf("Control Tower: Plane %s please wait, runway occupied%n", plane.getId());
    }
  }

  @Override
  public void requestTakeoff(Plane plane) {
    if (this.runwayClear) {
      this.runwayClear = false;
      System.out.printf("Control Tower: Takeoff permission granted to Plane %s%n", plane.getId());
      plane.takeoff();
      this.runwayClear = true;
    } else {
      System.out.printf("Control Tower: Plane %s please wait runway occupied%n");
    }
  }

  @Override
  public boolean isRunwayClear() {
    return this.runwayClear;
  }

}
