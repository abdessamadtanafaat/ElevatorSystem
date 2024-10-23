package model;

public class GoingUpState extends ElevatorState {
    @Override
    public double calculateDistance (int currentFloor, int targetFloor) {
        return targetFloor >= currentFloor ? targetFloor - currentFloor : Double.MAX_VALUE;

    }

}
