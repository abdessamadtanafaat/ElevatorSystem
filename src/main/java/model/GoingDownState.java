package model;

public class GoingDownState implements ElevatorState{

    private static GoingDownState instance = new GoingDownState();
    private GoingDownState() {}
    public static GoingDownState getInstance() {
        return instance;
    }
    @Override
    public double calculateDistance(Elevator elevator, int requestedFloor) {
        if (requestedFloor <= elevator.getCurrentFloor()){
            return Math.abs(elevator.getCurrentFloor() - requestedFloor);

        }else {
            return Double.MAX_VALUE;
        }
        }

}
