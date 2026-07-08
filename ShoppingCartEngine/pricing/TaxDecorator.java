package pricing;

/** Adds a percentage tax on top of the wrapped amount. */
public class TaxDecorator extends BillDecorator {
    private final double ratePercent;

    public TaxDecorator(Bill wrapped, double ratePercent) {
        super(wrapped);
        this.ratePercent = ratePercent;
    }

    @Override
    public double getAmount() {
        return wrapped.getAmount() * (1 + ratePercent / 100);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + " + ratePercent + "% tax";
    }
}
