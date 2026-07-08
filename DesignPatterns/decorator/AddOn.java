/**
 * Base decorator: IS-A Coffee and HAS-A Coffee (the one it wraps).
 * That double relationship is what lets add-ons stack on top of each other.
 */
public abstract class AddOn implements Coffee {
    protected final Coffee coffee;
    protected AddOn(Coffee coffee) { this.coffee = coffee; }
}
