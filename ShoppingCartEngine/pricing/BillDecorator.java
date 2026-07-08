package pricing;

/**
 * Base class for every charge/discount. The key of the Decorator pattern:
 * a decorator IS-A Bill and also HAS-A Bill (the one it wraps). Each concrete
 * decorator computes its amount from the wrapped bill's amount, then adds its
 * own twist.
 */
public abstract class BillDecorator implements Bill {
    protected final Bill wrapped;

    protected BillDecorator(Bill wrapped) {
        this.wrapped = wrapped;
    }
}
