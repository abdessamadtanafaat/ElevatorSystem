package model;

public interface ElevatorState {
    //public abstract double calculateDistance(int currentFloor, int targetFloor);
    double calculateDistance(Elevator elevator, int destinationFloor);
}
