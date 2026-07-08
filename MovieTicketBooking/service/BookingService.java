package service;

import java.util.List;
import java.util.UUID;

import enums.BookingStatus;
import model.Booking;
import model.Seat;
import model.Show;
import model.User;

/**
 * Orchestrates booking. It validates the seats, then asks the Show to reserve
 * them atomically. If the reserve fails (someone else took a seat), it returns a
 * FAILED booking instead of throwing — losing a race is expected, not a bug.
 */
public class BookingService {

    public Booking book(User user, Show show, List<String> seatIds) {
        // 1. validate that every requested seat actually exists on the screen
        for (String id : seatIds) {
            if (show.getScreen().getSeat(id) == null) {
                throw new IllegalArgumentException("No such seat: " + id);
            }
        }

        // 2. atomic check-and-reserve (thread-safe, no double booking)
        boolean reserved = show.tryReserve(seatIds);
        if (!reserved) {
            System.out.println("Booking FAILED for " + user.getName()
                    + " — a seat in " + seatIds + " is already taken.");
            return new Booking(UUID.randomUUID().toString(), user, show, seatIds, 0, BookingStatus.FAILED);
        }

        // 3. price it up (sum of seat-type prices) and confirm
        int amount = 0;
        for (String id : seatIds) {
            Seat seat = show.getScreen().getSeat(id);
            amount += seat.getType().getPrice();
        }
        Booking booking = new Booking(UUID.randomUUID().toString(), user, show, seatIds,
                amount, BookingStatus.CONFIRMED);
        System.out.println("Booking CONFIRMED for " + user.getName()
                + " seats " + seatIds + " amount ₹" + amount);
        return booking;
    }
}
