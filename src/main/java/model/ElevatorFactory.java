package model;

public class ElevatorFactory {
    public static Elevator createElevator(String description, int maxFloor) {
        String[] parts = description.split(":");
        String id = parts[0];
        int currentFloor = Integer.parseInt(parts[1]);
        return new Elevator(id, currentFloor, maxFloor);
    }
}
