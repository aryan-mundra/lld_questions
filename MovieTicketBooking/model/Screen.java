package model;

import java.util.List;

/** A hall/screen with a fixed seat layout. */
public class Screen {
    private final String name;
    private final List<Seat> seats;

    public Screen(String name, List<Seat> seats) {
        this.name = name;
        this.seats = seats;
    }

    public String getName() { return name; }
    public List<Seat> getSeats() { return seats; }

    public Seat getSeat(String seatId) {
        for (Seat s : seats) {
            if (s.getId().equals(seatId)) {
                return s;
            }
        }
        return null; // no such seat
    }
}
