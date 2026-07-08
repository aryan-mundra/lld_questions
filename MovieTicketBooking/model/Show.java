package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A movie playing on a screen at a given time. It tracks which seats are already
 * booked FOR THIS SHOW (the same physical seat is free again for the next show).
 *
 * The important method is tryReserve(): it checks availability AND reserves in
 * ONE synchronized step. That atomicity is what stops two users from booking the
 * same seat at the same time (the classic "check-then-act" race condition).
 */
public class Show {
    private final String id;
    private final Movie movie;
    private final Screen screen;
    private final String startTime;
    private final Set<String> bookedSeats = new HashSet<>();

    public Show(String id, Movie movie, Screen screen, String startTime) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
    }

    /**
     * Atomically reserve all requested seats. Returns false (reserving nothing)
     * if ANY of them is already taken. 'synchronized' guarantees only one thread
     * runs this at a time for this show, so the check and the reserve can't be
     * interleaved by another booking.
     */
    public synchronized boolean tryReserve(List<String> seatIds) {
        for (String id : seatIds) {
            if (bookedSeats.contains(id)) {
                return false; // at least one seat is gone -> reserve none
            }
        }
        bookedSeats.addAll(seatIds); // all free -> take them all
        return true;
    }

    public synchronized boolean isAvailable(String seatId) {
        return !bookedSeats.contains(seatId);
    }

    public synchronized List<String> availableSeats() {
        List<String> free = new ArrayList<>();
        for (Seat s : screen.getSeats()) {
            if (!bookedSeats.contains(s.getId())) {
                free.add(s.getId());
            }
        }
        return free;
    }

    public String getId() { return id; }
    public Movie getMovie() { return movie; }
    public Screen getScreen() { return screen; }
    public String getStartTime() { return startTime; }
}
