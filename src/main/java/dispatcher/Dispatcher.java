package dispatcher;

import model.Building;
import model.Elevator;

import java.util.Optional;

public class Dispatcher {
    private final Building building;

    public Dispatcher(Building building) {
        this.building = building;
    }

    // Handles elevator requests with prioritization for going up
    public String requestElevator(int requestedFloor) {
        // First, try to find an elevator that is going up and not stopping
        Optional<Elevator> upElevator = building.findElevatorGoingUp(requestedFloor);
        if (upElevator.isPresent()) {
            return upElevator.get().getId();
        }

        // If no elevator going up, fallback to finding the closest one
        Optional<Elevator> elevator = building.findClosestElevator(requestedFloor);
        return elevator.map(Elevator::getId).orElse(null);
    }

    public void moveElevator(String elevatorId, String direction) {
        building.move(elevatorId, direction);
    }

    public void stopElevatorAt(String elevatorId, int floor) {
        building.stopAt(elevatorId, floor);
    }
}
