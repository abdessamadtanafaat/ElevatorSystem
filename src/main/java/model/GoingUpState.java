package model;

public class GoingUpState implements ElevatorState {

    private static GoingUpState instance = new GoingUpState();
    private GoingUpState() {}

    public static GoingUpState getInstance(){
        return instance;
    }

    @Override
    public double calculateDistance(Elevator elevator, int requestedFloor) {
        if (requestedFloor >= elevator.getCurrentFloor()) {
            return Math.abs(requestedFloor - elevator.getCurrentFloor());
        } else {
            return Double.MAX_VALUE;
        }
    }

}
