package service;

import java.util.ArrayList;
import java.util.List;

import model.ParkingSpot;
import model.Vehicle;

/**
 * One level of the lot. Owns a list of spots and knows how to hand out
 * the first spot that fits a given vehicle.
 */
public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> spots = new ArrayList<>();

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    /**
     * Return the first free spot that can hold the vehicle, or null if
     * this floor is full for that vehicle. The caller decides what to do.
     */
    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.canFit(vehicle)) {
                return spot;
            }
        }
        return null;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
