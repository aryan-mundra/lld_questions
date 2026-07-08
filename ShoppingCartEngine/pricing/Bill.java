package pricing;

/**
 * The shared interface for the Decorator pattern. Both the base bill and every
 * charge/discount that wraps it are a Bill, so they can be stacked freely: each
 * layer takes a Bill and produces a Bill.
 */
public interface Bill {
    double getAmount();
    String getDescription();
}
