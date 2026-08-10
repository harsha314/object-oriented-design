package com.practice.elevator.system;

import java.util.List;

public class FCFCStrategy implements DispatchStrategy {

    @Override
    public Elevator request(List<Elevator> elevators, int floor, ElevatorDirection direction) {
        for(Elevator elevator : elevators) {
            if(ElevatorDirection.IDLE.equals(elevator.getState())) {
                return elevator;
            } else if(direction.equals(elevator.getState())) {
                if(ElevatorDirection.UP.equals(elevator.getState())) {
                    if(floor > elevator.getFloor()) {
                        return elevator;
                    }
                } else if(ElevatorDirection.DOWN.equals(elevator.getState())) {
                    if(floor < elevator.getFloor()) {
                        return elevator;
                    }
                }
            }
        }
        return null;
    }
}
