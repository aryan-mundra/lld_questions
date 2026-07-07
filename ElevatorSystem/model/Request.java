package model;

import enums.Direction;

/**
 * A call for an elevator. Covers both cases:
 *  - a hall call  (someone on a floor presses UP/DOWN)  -> direction is UP/DOWN
 *  - a car call   (a rider inside picks a destination)  -> direction can be IDLE
 * Either way it boils down to "please stop at this floor".
 */
public class Request {
    private final int floor;
    private final Direction direction;

    public Request(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}
