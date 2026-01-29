package com.questions.parkinglot.model;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Spot {
  private String id = UUID.randomUUID().toString();
  private VehicleType vehicleType;
  private boolean isReserved;

  public Spot(VehicleType vehicleType) {
    this.vehicleType = vehicleType;
    this.isReserved = false;
  }
}
