package enums;

/**
 * Seat categories, each with its own price (in rupees).
 * Attaching the price to the enum keeps pricing to a simple lookup.
 */
public enum SeatType {
    REGULAR(200),
    PREMIUM(350);

    private final int price;

    SeatType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
