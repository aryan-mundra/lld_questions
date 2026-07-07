package model;

import enums.VehicleType;

/**
 * Base class for every vehicle that can enter the lot.
 * We keep it abstract so nobody creates a "generic" vehicle —
 * callers must pick a concrete type (Car, Truck, Motorcycle).
 */
public abstract class Vehicle {
    private final String licensePlate;
    private final VehicleType type;

    protected Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
}
