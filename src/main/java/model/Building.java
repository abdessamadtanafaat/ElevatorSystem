package model;
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
        return elevators.stream()
                .min((e1,e2) -> Double.compare
                        (e1.calculateDistance(numberOfFloors)
                                ,e2.calculateDistance(numberOfFloors)))
                d.orElseThrow(()-> new RuntimeException("No elevators available"))
                .getId();
    }

}
