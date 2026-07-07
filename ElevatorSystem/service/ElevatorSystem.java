package service;

import java.util.ArrayList;
import java.util.List;

import model.Elevator;
import model.Request;

/**
 * The controller / facade. Holds all the cars and a scheduling strategy.
 * When a request comes in it asks the strategy which car should take it,
 * then hands the stop to that car. step() advances the whole simulation.
 */
public class ElevatorSystem {
    private final List<Elevator> elevators = new ArrayList<>();
    private final SchedulingStrategy strategy;

    public ElevatorSystem(SchedulingStrategy strategy) {
        this.strategy = strategy;
    }

    public void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }

    public void requestElevator(Request request) {
        Elevator chosen = strategy.selectElevator(request, elevators);
        System.out.println("Request for floor " + request.getFloor()
                + " -> assigned to Elevator " + chosen.getId());
        chosen.addStop(request.getFloor());
    }

    /** One tick of time: every car moves one step. */
    public void step() {
        for (Elevator elevator : elevators) {
            elevator.step();
        }
    }

    public boolean anyWork() {
        for (Elevator elevator : elevators) {
            if (elevator.hasWork()) {
                return true;
            }
        }
        return false;
    }

    public List<Elevator> getElevators() {
        return elevators;
    }
}
