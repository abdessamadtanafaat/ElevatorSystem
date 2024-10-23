package model;

public class Elevator {
    private String id;
    private int currentFloor;
    private ElevatorState state;

   public Elevator(String id, int currentFloor, ElevatorState state){
       this.id = id;
       this.currentFloor = currentFloor;
       this.state = RestingState.getInstance();
   }

   public double calculateDistance(int destinationFloor) {
       return state.calculateDistance(this, destinationFloor);
   }
   public String getId() {
       return id;
   }
   public int getCurrentFloor() {
       return currentFloor;
   }
    public void setState(ElevatorState state){
       this.state = state;
    }

}
