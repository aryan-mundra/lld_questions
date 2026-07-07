package service;

import java.time.Duration;

import enums.VehicleType;
import model.Ticket;

/**
 * Strategy for pricing. Kept as its own class so the fee rules can change
 * (hourly, flat, weekend rates...) without touching the parking logic.
 */
public class FeeCalculator {

    // Simple per-hour rates by vehicle type.
    private double ratePerHour(VehicleType type) {
        switch (type) {
            case MOTORCYCLE: return 10;
            case CAR:        return 20;
            case TRUCK:      return 40;
            default:         return 0;
        }
    }

    public double calculate(Ticket ticket) {
        long hours = Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toHours();
        hours = Math.max(1, hours); // charge at least one hour
        return hours * ratePerHour(ticket.getVehicle().getType());
    }
}
