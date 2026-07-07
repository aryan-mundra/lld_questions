package model;

import enums.SpotType;

/**
 * A single parking spot on a floor.
 * It knows its size and whether it currently holds a vehicle.
 */
public class ParkingSpot {
    private final String spotId;
    private final SpotType spotType;
    private Vehicle parkedVehicle; // null when the spot is free

    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
    }

    public boolean isFree() {
        return parkedVehicle == null;
    }

    /**
     * A spot can hold a vehicle only if it's free AND is exactly the spot type
     * that vehicle requires (motorcycle→SMALL, car→MEDIUM, truck→LARGE).
     * The mapping lives on VehicleType, so this stays a one-line check and
     * adding a new vehicle type needs no change here.
     */
    public boolean canFit(Vehicle vehicle) {
        if (!isFree()) {
            return false;
        }
        return spotType == vehicle.getType().getRequiredSpot();
    }

    public void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
    }

    public String getSpotId() {
        return spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
