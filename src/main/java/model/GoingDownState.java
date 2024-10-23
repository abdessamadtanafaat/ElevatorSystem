package model;

public class GoingDownState implements ElevatorState{

    private static GoingDownState instance;
    private GoingDownState() {}
    public static GoingDownState getInstance() {
        if(instance == null) {
            instance = new GoingDownState();
        }
        return instance;
    }
    @Override
    public double calculateDistance(Elevator elevator, int destinationFloor) {
        if (elevator.getCurrentFloor() < destinationFloor) {
            return Double.MAX_VALUE;
        }
        return elevator.getCurrentFloor() - destinationFloor;
    }

}
