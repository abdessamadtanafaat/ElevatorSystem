package model;

public class Elevator {
    private final String id;
    private int currentFloor;
    private final int maxFloor;
    private ElevatorState state;

    public Elevator(String id, int currentFloor, int maxFloor) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.maxFloor = maxFloor;
        this.state = new RestingState(); // Initial state is Resting
    }

    public String getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public ElevatorState getState() {
        return state;  // Added for state access
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public void move(String direction) {
        if ("UP".equalsIgnoreCase(direction)) {
            this.state = new GoingUpState();
        } else if ("DOWN".equalsIgnoreCase(direction)) {
            this.state = new GoingDownState();
        } else {
            this.state = new RestingState();
        }
    }

    public void stopAt(int floor) {
        this.state = new RestingState();
        this.currentFloor = floor;
    }

    public boolean canServeRequestFromFloor(int floor) {
        return state.canServeRequestFromFloor(floor, this);
    }

    public void moveOneStep() {
        state.move(this);
    }

    // New method to check if the elevator is going up
    public boolean isGoingUp() {
        return state instanceof GoingUpState; // Check if the current state is GoingUpState
    }

    // New method to check if the elevator is resting
    public boolean isResting() {
        return state instanceof RestingState; // Check if the current state is RestingState
    }
}
