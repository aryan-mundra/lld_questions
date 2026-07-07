package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;

/**
 * The main entry point / facade for the system.
 * Clients only talk to this class: they park a vehicle and get a ticket,
 * then hand the ticket back on exit to get charged.
 */
public class ParkingLot {
    private final List<ParkingFloor> floors = new ArrayList<>();
    private final FeeCalculator feeCalculator = new FeeCalculator();

    // Active tickets, keyed by ticketId, so exit() can look them up fast.
    private final Map<String, Ticket> activeTickets = new HashMap<>();

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    /**
     * Try to park a vehicle. Walks the floors in order and takes the first
     * fitting spot. Returns a ticket, or null if the whole lot is full.
     */
    public Ticket park(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle);
            if (spot != null) {
                spot.park(vehicle);
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, spot);
                activeTickets.put(ticket.getTicketId(), ticket);
                System.out.println("Parked " + vehicle.getLicensePlate()
                        + " at spot " + spot.getSpotId());
                return ticket;
            }
        }
        System.out.println("Lot full — no spot for " + vehicle.getLicensePlate());
        return null;
    }

    /**
     * Free the spot, compute the fee, and close out the ticket.
     * Returns the amount owed, or -1 if the ticket is unknown.
     */
    public double exit(String ticketId) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) {
            System.out.println("Unknown ticket: " + ticketId);
            return -1;
        }
        ticket.markExit();
        ticket.getSpot().removeVehicle();
        double fee = feeCalculator.calculate(ticket);
        System.out.println("Vehicle " + ticket.getVehicle().getLicensePlate()
                + " exited. Fee = " + fee);
        return fee;
    }
}
