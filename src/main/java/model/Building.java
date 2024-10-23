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


    public String requestElevator() {

        Dispatcher dispatcher = Dispatcher.getInstance();
        return dispatcher.findClosetElevevator(elevators, numberOfFloors);
    }

}
