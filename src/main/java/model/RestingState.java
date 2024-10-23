package model;

public class RestingState implements ElevatorState {

    private static RestingState instance;

    private RestingState(){}
        public static RestingState getInstance() {
            if (instance == null) {
                instance = new  RestingState();
            }
        return instance;
    }
    @Override

    public double calculateDistance(Elevator elevator, int destinationFloor){
        return Math.abs(elevator.getCurrentFloor() - destinationFloor);

    }

}
