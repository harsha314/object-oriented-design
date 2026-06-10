package com.book.elevator.system;

import java.util.List;

public class FCFSDispatchStrategy implements DispatchStrategy {
    @Override
    public ElevatorCar selectElevator(List<ElevatorCar> elevatorCars, int floor, Direction direction) {
        for(ElevatorCar car : elevatorCars) {
            if(car.isIdle() || car.getCurrentDirection() == direction) {
                return car;
            }
        }
        return elevatorCars.get((int)(Math.random() * elevatorCars.size())) ;
    }
}
