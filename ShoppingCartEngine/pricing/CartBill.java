package pricing;

import model.ShoppingCart;

/**
 * The base component that everything else wraps: the raw cart subtotal.
 * This is the innermost layer of the Decorator "onion".
 */
public class CartBill implements Bill {
    private final ShoppingCart cart;

    public CartBill(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public double getAmount() {
        return cart.getSubtotal();
    }

    @Override
    public String getDescription() {
        return "Subtotal";
    }
}
