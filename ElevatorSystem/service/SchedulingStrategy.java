package service;

import java.util.List;

import model.Elevator;
import model.Request;

/**
 * The rule for deciding WHICH elevator should answer a request.
 * Kept behind an interface (Strategy pattern) so we can swap "nearest car"
 * for "least busy", "energy saving", etc. without touching the controller.
 */
public interface SchedulingStrategy {
    Elevator selectElevator(Request request, List<Elevator> elevators);
}
