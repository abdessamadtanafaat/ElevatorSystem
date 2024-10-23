package model;

public class GoingDownState extends ElevatorState{
    @Override
    public double calculateDistance(int currentFloor, int targetFloor) {
        return targetFloor <= currentFloor ? currentFloor - targetFloor : Double.MAX_VALUE;

    }
}
