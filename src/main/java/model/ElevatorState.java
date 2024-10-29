package model;

public interface ElevatorState {
    void move(Elevator elevator);
    boolean canServeRequestFromFloor(int floor, Elevator elevator);
}
