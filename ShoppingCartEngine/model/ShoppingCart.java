package model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The cart. Items are keyed by product id so adding the same product again
 * just bumps its quantity (no duplicate lines). LinkedHashMap keeps them in
 * the order they were first added, which is nicer to display.
 */
public class ShoppingCart {
    private final Map<String, CartItem> items = new LinkedHashMap<>();

    public void addItem(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
        CartItem existing = items.get(product.getId());
        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + quantity);
        } else {
            items.put(product.getId(), new CartItem(product, quantity));
        }
    }

    public void removeItem(String productId) {
        items.remove(productId);
    }

    /** Setting quantity to 0 (or less) removes the line entirely. */
    public void updateQuantity(String productId, int quantity) {
        if (quantity <= 0) {
            items.remove(productId);
            return;
        }
        CartItem item = items.get(productId);
        if (item != null) {
            item.setQuantity(quantity);
        }
    }

    public double getSubtotal() {
        double sum = 0;
        for (CartItem item : items.values()) {
            sum += item.getTotalPrice();
        }
        return sum;
    }

    public Collection<CartItem> getItems() { return items.values(); }
    public boolean isEmpty() { return items.isEmpty(); }
}
