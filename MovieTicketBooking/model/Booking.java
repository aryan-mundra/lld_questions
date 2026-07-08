package model;

import java.util.List;

import enums.BookingStatus;

/** The result of a booking attempt — who, which show, which seats, price, status. */
public class Booking {
    private final String id;
    private final User user;
    private final Show show;
    private final List<String> seatIds;
    private final int amount;
    private final BookingStatus status;

    public Booking(String id, User user, Show show, List<String> seatIds,
                   int amount, BookingStatus status) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.seatIds = seatIds;
        this.amount = amount;
        this.status = status;
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public List<String> getSeatIds() { return seatIds; }
    public int getAmount() { return amount; }
    public BookingStatus getStatus() { return status; }
}
