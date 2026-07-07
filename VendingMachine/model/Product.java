package model;

/**
 * A product the machine can sell. Plain data holder: a code (like "A1"),
 * a display name, and a price in cents.
 */
public class Product {
    private final String code;
    private final String name;
    private final int price; // in cents

    public Product(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
