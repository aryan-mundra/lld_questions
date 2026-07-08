package model;

import enums.SeatType;

/** A physical seat on a screen (e.g. "A1"), with its category. */
public class Seat {
    private final String id;
    private final SeatType type;

    public Seat(String id, SeatType type) {
        this.id = id;
        this.type = type;
    }

    public String getId() { return id; }
    public SeatType getType() { return type; }
}
