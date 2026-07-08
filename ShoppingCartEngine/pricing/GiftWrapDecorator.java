package pricing;

/** Adds a flat gift-wrap fee to the wrapped amount. */
public class GiftWrapDecorator extends BillDecorator {
    private final double fee;

    public GiftWrapDecorator(Bill wrapped, double fee) {
        super(wrapped);
        this.fee = fee;
    }

    @Override
    public double getAmount() {
        return wrapped.getAmount() + fee;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + gift wrap (" + fee + ")";
    }
}
