import model.CartItem;
import model.Product;
import model.ShoppingCart;
import pricing.Bill;
import pricing.CartBill;
import pricing.CouponDecorator;
import pricing.GiftWrapDecorator;
import pricing.PercentageDiscountDecorator;
import pricing.TaxDecorator;

/**
 * Demo: fill a cart, then build the final bill by STACKING decorators.
 * The order you wrap them in is the order they apply — that's the whole point.
 */
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Product("P1", "Notebook", 120), 2); // 240
        cart.addItem(new Product("P2", "Pen", 20), 5);       // 100
        cart.addItem(new Product("P1", "Notebook", 120), 1); // merges -> Notebook x3 = 360

        System.out.println("Cart:");
        for (CartItem item : cart.getItems()) {
            System.out.println("  " + item.getQuantity() + " x " + item.getProduct().getName()
                    + " = " + item.getTotalPrice());
        }
        System.out.println("Subtotal = " + cart.getSubtotal());

        // Stack charges/discounts (order matters!):
        // subtotal -> -10% member -> +8% tax -> -50 coupon -> +30 gift wrap
        Bill bill = new CartBill(cart);
        bill = new PercentageDiscountDecorator(bill, "member", 10);
        bill = new TaxDecorator(bill, 8);
        bill = new CouponDecorator(bill, "SAVE50", 50);
        bill = new GiftWrapDecorator(bill, 30);

        System.out.println("\n" + bill.getDescription());
        System.out.printf("Total = %.2f%n", bill.getAmount());

        // Mutating the cart is reflected because the bill reads it live.
        cart.updateQuantity("P2", 2); // pens 5 -> 2
        cart.removeItem("P1");        // drop notebooks
        System.out.println("\nAfter update + remove, subtotal = " + cart.getSubtotal());
    }
}
