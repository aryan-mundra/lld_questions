package pricing;

/** Takes a percentage off the wrapped amount (e.g. a 10% member discount). */
public class PercentageDiscountDecorator extends BillDecorator {
    private final double percent;
    private final String label;

    public PercentageDiscountDecorator(Bill wrapped, String label, double percent) {
        super(wrapped);
        this.label = label;
        this.percent = percent;
    }

    @Override
    public double getAmount() {
        return wrapped.getAmount() * (1 - percent / 100);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " - " + percent + "% " + label;
    }
}
