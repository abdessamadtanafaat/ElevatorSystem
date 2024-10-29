package model;

import dispatcher.Dispatcher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Building {
    private final int numberOfFloors;
    private final List<Elevator> elevators;
    private final Dispatcher dispatcher;

    public Building(int numberOfFloors, String... elevatorDescriptions) {
        this.numberOfFloors = numberOfFloors;
        this.elevators = new ArrayList<>();
        for (String desc : elevatorDescriptions) {
            elevators.add(ElevatorFactory.createElevator(desc, numberOfFloors));
        }
        this.dispatcher = new Dispatcher(this);
    }

    public String requestElevator() {
        Elevator closestResting = null;
        Elevator closestGoingUp = null;

        for (Elevator elevator : elevators) {
            System.out.println("Evaluating Elevator ID: " + elevator.getId() + ", Current Floor: " + elevator.getCurrentFloor() + ", State: " + elevator.getState().getClass().getSimpleName());

            if (elevator.isResting()) {
                // Prioritize resting elevators
                if (closestResting == null || elevator.getCurrentFloor() > closestResting.getCurrentFloor()) {
                    closestResting = elevator;
                }
            } else if (elevator.isGoingUp()) {
                // Look for moving up elevators if no resting elevators are found
                if (closestGoingUp == null || elevator.getCurrentFloor() > closestGoingUp.getCurrentFloor()) {
                    closestGoingUp = elevator;
                }
            }
        }

        // Return the ID of the closest elevator
        if (closestResting != null) {
            return closestResting.getId(); // Return the resting elevator if available
        } else if (closestGoingUp != null) {
            return closestGoingUp.getId(); // Otherwise, return the elevator going up
        }

        return null; // Handle case when no elevators are available
    }

    public String requestElevator(int requestedFloor) {
        return dispatcher.requestElevator(requestedFloor);
    }

    // Change access modifier to public or protected
    public Optional<Elevator> findClosestElevator(int requestedFloor) {
        return elevators.stream()
                .filter(e -> e.canServeRequestFromFloor(requestedFloor))
                .sorted(Comparator.comparingInt(e -> {
                    // Prioritize elevators that are going up
                    if (e.isGoingUp()) {
                        return Math.abs(e.getCurrentFloor() - requestedFloor) - 1000; // Arbitrary large number to prioritize
                    }
                    return Math.abs(e.getCurrentFloor() - requestedFloor);
                }))
                .findFirst();
    }



    // New method to find elevators going up
    public Optional<Elevator> findElevatorGoingUp(int requestedFloor) {
        return elevators.stream()
                .filter(elevator -> elevator.getCurrentFloor() < requestedFloor && elevator.isGoingUp())
                .findFirst();
    }

    public void move(String elevatorId, String direction) {
        elevators.stream()
                .filter(e -> e.getId().equals(elevatorId))
                .findFirst()
                .ifPresent(e -> e.move(direction));
    }

    public void stopAt(String elevatorId, int floor) {
        elevators.stream()
                .filter(e -> e.getId().equals(elevatorId))
                .findFirst()
                .ifPresent(e -> e.stopAt(floor));
    }
}
