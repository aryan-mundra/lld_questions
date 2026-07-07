package model;

import enums.Direction;
import enums.ElevatorState;

import java.util.TreeSet;

/**
 * A single elevator car. It knows its floor, its direction, and the set of
 * floors it still has to visit. The stops are kept in a TreeSet (sorted) so we
 * can efficiently find the next stop in the direction we're already going —
 * that's the simple "keep going the same way until there's nothing left" rule
 * (a mini SCAN algorithm), which avoids pointless back-and-forth.
 */
public class Elevator {
    private final int id;
    private int currentFloor;
    private Direction direction = Direction.IDLE;
    private ElevatorState state = ElevatorState.IDLE;
    private final TreeSet<Integer> stops = new TreeSet<>();

    public Elevator(int id, int startFloor) {
        this.id = id;
        this.currentFloor = startFloor;
    }

    /** Register a floor this car must visit. */
    public void addStop(int floor) {
        if (floor == currentFloor) {
            openDoors();               // already here
            return;
        }
        stops.add(floor);
        if (direction == Direction.IDLE) {
            direction = floor > currentFloor ? Direction.UP : Direction.DOWN;
        }
    }

    /** Advance the simulation by one "tick": move one floor toward the next stop. */
    public void step() {
        if (stops.isEmpty()) {
            becomeIdle();
            return;
        }
        state = ElevatorState.MOVING;
        int target = nextTarget();

        if (target > currentFloor) {
            currentFloor++;
            direction = Direction.UP;
        } else if (target < currentFloor) {
            currentFloor--;
            direction = Direction.DOWN;
        }

        if (stops.remove(currentFloor)) {
            openDoors();
        }
        if (stops.isEmpty()) {
            becomeIdle();
        }
    }

    /**
     * Pick the next floor to head for. Prefer continuing in the current
     * direction; only when there's nothing left that way do we turn around.
     */
    private int nextTarget() {
        if (direction == Direction.DOWN) {
            Integer below = stops.floor(currentFloor);   // nearest stop <= current
            return (below != null) ? below : stops.first();
        }
        Integer above = stops.ceiling(currentFloor);     // nearest stop >= current
        return (above != null) ? above : stops.last();
    }

    private void openDoors() {
        state = ElevatorState.DOORS_OPEN;
        System.out.println("  Elevator " + id + " reached floor " + currentFloor + " -> doors open");
    }

    private void becomeIdle() {
        direction = Direction.IDLE;
        state = ElevatorState.IDLE;
    }

    public int getId() { return id; }
    public int getCurrentFloor() { return currentFloor; }
    public Direction getDirection() { return direction; }
    public ElevatorState getState() { return state; }
    public boolean hasWork() { return !stops.isEmpty(); }
}
