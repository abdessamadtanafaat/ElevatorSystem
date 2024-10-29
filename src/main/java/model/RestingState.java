package model;

public class RestingState implements ElevatorState {
    @Override
    public void move(Elevator elevator) {
        // No movement if resting
    }

    @Override
    public boolean canServeRequestFromFloor(int floor, Elevator elevator) {
        return true;
    }
}
