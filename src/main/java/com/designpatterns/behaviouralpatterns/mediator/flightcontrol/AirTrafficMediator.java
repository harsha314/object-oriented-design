package com.designpatterns.behaviouralpatterns.mediator.flightcontrol;

public interface AirTrafficMediator {
  void registerPlane(Plane plane);

  void requestLanding(Plane plane);

  void requestTakeoff(Plane plane);

  boolean isRunwayClear();
}
