package model;

public class RestingState implements ElevatorState {

    private static RestingState instance = new RestingState();

    private RestingState(){}
        public static RestingState getInstance() {
            return instance;
    }
    @Override

    public double calculateDistance(Elevator elevator, int requestedFloor){
        return Math.abs(requestedFloor - elevator.getCurrentFloor());

    }

}
