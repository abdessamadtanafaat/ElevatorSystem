package model;
import dispatcher.Dispatcher;

import java.util.*;
public class Building {
    private int numberOfFloors;
    private List<Elevator> elevators;

    public Building(int numberOfFloors, String... elevatorData) {
        this.numberOfFloors = numberOfFloors;
        ElevatorFactory factory = new ElevatorFactory();
        elevators = factory.createElevators(elevatorData);
    }


    public List<Elevator> getElevators() {
        return elevators;
    }
    public String requestElevator() {
        return Dispatcher.getInstance().dispatchElevator(elevators, numberOfFloors);
    }

    public String requestElevator(int requestedFloor){
        return Dispatcher.getInstance().dispatchElevator(elevators,requestedFloor);
    }
    public void move(String elevatorId, String direction){
        elevators.stream()
                .filter(elevator -> elevator.getId().equals(elevatorId))
                .forEach(e->e.changeDirection(direction));
                }
    public void stopAt(String elevatorId, int floor) {
        elevators.stream()
                .filter(e-> e.getId()
                        .equals(elevatorId))
                        .forEach(e->e.stopAt(floor));

    }

}
