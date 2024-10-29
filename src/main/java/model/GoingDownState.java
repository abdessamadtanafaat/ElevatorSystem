package model;

public class GoingDownState implements ElevatorState {
    @Override
    public void move(Elevator elevator) {
        if (elevator.getCurrentFloor() > 1) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
        } else {
            elevator.setState(new GoingUpState());
        }
    }

    @Override
    public boolean canServeRequestFromFloor(int floor, Elevator elevator) {
        return elevator.getCurrentFloor() >= floor;
    }
}
