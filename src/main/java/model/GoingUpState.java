package model;

public class GoingUpState implements ElevatorState {

    private static GoingUpState instance;
    private GoingUpState() {}

    public static GoingUpState getInstance(){
        if (instance == null) {
            instance = new GoingUpState();
        }
        return instance;
    }

    @Override
    public double calculateDistance(Elevator elevator, int destinationFloor) {
        if (elevator.getCurrentFloor() > destinationFloor) {
            return Double.MAX_VALUE;
}
        return destinationFloor - elevator.getCurrentFloor();
    }

}
