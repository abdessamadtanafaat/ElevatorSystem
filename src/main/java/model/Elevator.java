package model;

public class Elevator {
    private String id;
    private int currentFloor;
    private ElevatorState state;

   public Elevator(String id, int currentFloor, ElevatorState initialState){
       this.id = id;
       this.currentFloor = currentFloor;
       this.state = initialState;
   }

   public double calculateDistance(int requestedFloor) {
       return state.calculateDistance(this, requestedFloor);
   }
   public void changeDirection(String direction) {
       if (direction.equalsIgnoreCase("UP")) {
           this.state = GoingUpState.getInstance();

       }else if (direction.equalsIgnoreCase("DOWN")){
           this.state = GoingDownState.getInstance();
       }
   }
   public void stopAt (int floor) {
       this.currentFloor = floor;
       this.state = RestingState.getInstance();
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
