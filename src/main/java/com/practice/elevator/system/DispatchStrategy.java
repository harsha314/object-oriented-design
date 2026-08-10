package com.practice.elevator.system;

import java.util.List;

public interface DispatchStrategy {
    Elevator request(List<Elevator> elevators, int floor, ElevatorDirection direction);
}
