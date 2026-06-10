package com.book.elevator.system;

import java.util.List;

public interface DispatchStrategy {
    ElevatorCar selectElevator(List<ElevatorCar> elevatorCars, int floor, Direction direction);
}
