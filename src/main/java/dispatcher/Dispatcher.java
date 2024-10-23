package dispatcher;

import model.Elevator;

import java.util.*;
public class Dispatcher {
    private static Dispatcher instance;
    private Dispatcher() {}

    public static Dispatcher getInstance() {
        if (instance == null) {
            instance = new Dispatcher();
        }
        return instance;
    }

    public String findClosetElevevator(List<Elevator> elevators, int topFloor){
            return elevators.stream()
                    .min((e1, e2) -> Double.compare(
                            e1.calculateDistance(topFloor),
                            e2.calculateDistance(topFloor)))
                    .orElseThrow(() -> new RuntimeException("No Elevators available"))
                    .getId();
    }
}
