package com.practice.elevator.system;

public class Main {
    // Core Entities:
    // Elevator: reps the current state of an elevator
    // ElevatorSystem: manages user requests

    // Classes
    // ElevatorState: IDLE, UP, DOWN
    // ElevatorStatus: (elevatorState, elevatorFloor)

    // Elevator: (id, ElevatorStatus)
    //   void toFloor(int floor);

    // ElevatorSystem: (List<Elevator> elevators, IDispatchStrategy strategy)
    //   void requestElevatorFromOutside(int floor, int direction)

    // IDispatchStrategy :
    //   void dispatch(List<Elevator> elevators, int floor, int direction)
}
