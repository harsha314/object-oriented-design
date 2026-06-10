package com.book.elevator.system;

import java.util.LinkedList;
import java.util.Queue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElevatorCar {
    private ElevatorStatus status;
    private Queue<Integer> targetFloors;

    public ElevatorCar(int startingFloor) {
        this.status = new ElevatorStatus(startingFloor, Direction.IDLE) ;
        this.targetFloors = new LinkedList<>();
    }

    public Direction getCurrentDirection() {
        return this.status.getCurrentDirection();
    }

    public void addFloorRequest(int floor) {
        this.targetFloors.add(floor);
    }

    boolean isIdle() {
        return Direction.IDLE.equals(this.status.getCurrentDirection());
    }
    
    public void updateDirection(int targetFloor) {
        if(status.getCurrentFloor() < targetFloor) {
            status = new ElevatorStatus(status.getCurrentFloor(), Direction.UP);
        } else {
            status = new ElevatorStatus(status.getCurrentFloor(), Direction.DOWN);
        }
    }
}
