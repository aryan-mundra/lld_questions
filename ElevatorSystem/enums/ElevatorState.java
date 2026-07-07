package enums;

/**
 * What the car is doing right now. Kept separate from Direction because a car
 * can be, say, MOVING while its Direction is UP, or DOORS_OPEN while stopped.
 */
public enum ElevatorState {
    IDLE,
    MOVING,
    DOORS_OPEN
}
