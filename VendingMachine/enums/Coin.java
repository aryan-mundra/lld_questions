package enums;

/**
 * The coins the machine accepts. Each carries its value in cents,
 * so the machine can just sum coin values to track the balance.
 */
public enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
