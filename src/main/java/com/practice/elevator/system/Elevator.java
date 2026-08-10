package com.practice.elevator.system;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

@Data
public class Elevator {
    private ElevatorDirection state;
    private int floor;
    Queue<Integer> stops;

    public Elevator(int floor) {
        this.floor = floor;
        this.state = ElevatorDirection.IDLE;
        this.stops = new LinkedList<>();
    }

    public void toFloor(int floor) {
        if (state == ElevatorDirection.IDLE) {
            this.stops.add(floor);
        } else if(state == ElevatorDirection.UP) {
            if(floor > this.floor) {
                this.stops.add(floor);
            }
        } else if(state == ElevatorDirection.DOWN) {
            if(floor < this.floor) {
                this.stops.add(floor);
            }
        }

    }
}
