package com.questions.parkinglot.repository;

import java.util.HashMap;
import java.util.Map;

import com.questions.parkinglot.model.Spot;
import com.questions.parkinglot.model.VehicleType;

public class SpotRepository {
  private Map<String, Spot> data = new HashMap<>();

  public Spot getSpot(String spotId) {
    return data.get(spotId);
  }

  public Spot getEmptySpot(VehicleType vehicleType) {
    return data.values().stream()
        .filter(spot -> spot.getVehicleType() == vehicleType && !spot.isReserved())
        .findFirst()
        .get();
  }

}
