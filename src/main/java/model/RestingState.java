package model;

public class RestingState extends ElevatorState {

    @Override
    public double calculateDistance(int currentFloor, int targetFloor ){
        return Math.abs(currentFloor - targetFloor);
    }

}
