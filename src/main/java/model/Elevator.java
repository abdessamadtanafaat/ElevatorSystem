package model;

public class Elevator {
    private String id;
    private int currentFloor;
    private ElevatorState state;

   public Elevator(String id, int currentFloor, ElevatorState state){
       this.id = id;
       this.currentFloor = currentFloor;
       this.state = state;


   }

   public double calculateDistance(int targetFloor) {
       return state.calculateDistance(currentFloor,targetFloor);
   }
   public String getId() {
       return id;
   }
    public void setState(ElevatorState state){
       this.state = state;
    }

}
