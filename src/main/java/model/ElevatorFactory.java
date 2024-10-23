package model;
import java.util.*;
public class ElevatorFactory {
   public List<Elevator> createElevators(String... elevatorData){
       List<Elevator> elevators = new ArrayList<>();

       for (String data : elevatorData){
           String[] parts = data.split(":");
           String id = parts[0];
           int currentFloor = Integer.parseInt(parts[1]);

           ElevatorState initialState = currentFloor == 1 ?
                   new GoingUpState() : new RestingState();

           elevators.add(new Elevator(id, currentFloor, initialState));
       }
       return elevators;
   }
}
