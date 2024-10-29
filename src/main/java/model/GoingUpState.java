package model;

public class GoingUpState implements ElevatorState {
    @Override
    public void move(Elevator elevator) {
        if (elevator.getCurrentFloor() < elevator.getMaxFloor()) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
        } else {
            elevator.setState(new GoingDownState());
        }
    }

    @Override
    public boolean canServeRequestFromFloor(int floor, Elevator elevator) {
        return elevator.getCurrentFloor() <= floor;
    }
}
