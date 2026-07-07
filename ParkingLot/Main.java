import enums.SpotType;
import model.Car;
import model.Motorcycle;
import model.ParkingSpot;
import model.Ticket;
import model.Truck;
import service.ParkingFloor;
import service.ParkingLot;

/**
 * A small demo that wires everything together and runs a few scenarios.
 * This is where you'd normally "show your usage" in an LLD interview.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Build the lot: one floor with a mix of spot sizes.
        ParkingLot lot = new ParkingLot();
        ParkingFloor floor = new ParkingFloor(1);
        floor.addSpot(new ParkingSpot("F1-S1", SpotType.SMALL));
        floor.addSpot(new ParkingSpot("F1-M1", SpotType.MEDIUM));
        floor.addSpot(new ParkingSpot("F1-L1", SpotType.LARGE));
        lot.addFloor(floor);

        // 2. Park a few vehicles.
        Ticket bikeTicket = lot.park(new Motorcycle("BIKE-1"));
        Ticket carTicket = lot.park(new Car("CAR-1"));
        Ticket truckTicket = lot.park(new Truck("TRUCK-1"));

        // 3. This car has no medium/large spot left -> lot full for it.
        lot.park(new Car("CAR-2"));

        // 4. Vehicles leave and get charged.
        lot.exit(bikeTicket.getTicketId());
        lot.exit(carTicket.getTicketId());
        lot.exit(truckTicket.getTicketId());

        // 5. Now that spots freed up, CAR-2 can park.
        lot.park(new Car("CAR-2"));
    }
}
