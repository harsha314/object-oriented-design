package com.book.elevator.system;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElevatorStatus {

    private int currentFloor;
    private Direction currentDirection;

    public ElevatorStatus(int startingFloor, Direction direction) {
        this.currentFloor = startingFloor ;
        this.currentDirection = direction;
    }
}
