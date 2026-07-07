package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks what products the machine holds and how many of each are left.
 * Keyed by product code so lookups on selection are O(1).
 */
public class Inventory {
    private final Map<String, Product> products = new HashMap<>();
    private final Map<String, Integer> counts = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        products.put(product.getCode(), product);
        counts.merge(product.getCode(), quantity, Integer::sum);
    }

    public Product getProduct(String code) {
        return products.get(code);
    }

    public boolean isAvailable(String code) {
        return counts.getOrDefault(code, 0) > 0;
    }

    public void reduceStock(String code) {
        counts.computeIfPresent(code, (k, qty) -> qty - 1);
    }

    public int getCount(String code) {
        return counts.getOrDefault(code, 0);
    }
}
