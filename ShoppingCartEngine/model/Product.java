package model;

/**
 * Something you can buy: an id, a display name, and a unit price.
 * Plain data holder — price lives with the product it belongs to.
 */
public class Product {
    private final String id;
    private final String name;
    private final double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
