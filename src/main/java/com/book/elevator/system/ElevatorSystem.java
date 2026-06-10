package com.book.elevator.system;

import java.util.List;

public class ElevatorSystem {
    private List<ElevatorCar> elevators;
    private ElevatorDispatch dispatchController;

    public List<ElevatorStatus> getAllElevatorStatus() {
        return this.elevators.stream().map(ElevatorCar::getStatus).toList();
    }

    public void requestElevator(int currentFloor, Direction direction) {
        dispatchController.dispatchElevatorCar(currentFloor, direction, elevators);
    }

    public void selectFloor(ElevatorCar car, int destinationFloor) {
        car.addFloorRequest(destinationFloor);
    }
}
