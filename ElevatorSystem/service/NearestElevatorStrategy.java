package service;

import java.util.List;

import model.Elevator;
import model.Request;

/**
 * Simplest useful rule: give the request to whichever car is fewest floors
 * away right now. Good enough for a first version; other strategies can be
 * dropped in later without changing anything else.
 */
public class NearestElevatorStrategy implements SchedulingStrategy {

    @Override
    public Elevator selectElevator(Request request, List<Elevator> elevators) {
        Elevator best = null;
        int bestDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - request.getFloor());
            if (distance < bestDistance) {
                bestDistance = distance;
                best = elevator;
            }
        }
        return best;
    }
}
