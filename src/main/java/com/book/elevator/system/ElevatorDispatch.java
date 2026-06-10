package com.book.elevator.system;

import java.util.List;

public class ElevatorDispatch {
    private final DispatchStrategy strategy;

    public ElevatorDispatch(DispatchStrategy strategy) {
        this.strategy = strategy;
    }

    public void dispatchElevatorCar(int floor, Direction direction, List<ElevatorCar> elevatorCars) {
        ElevatorCar elevatorCar = this.strategy.selectElevator(elevatorCars, floor, direction) ;
        elevatorCar.addFloorRequest(floor);
    }
}
