package pricing;

/** Subtracts a flat coupon amount (never below zero). */
public class CouponDecorator extends BillDecorator {
    private final String code;
    private final double amountOff;

    public CouponDecorator(Bill wrapped, String code, double amountOff) {
        super(wrapped);
        this.code = code;
        this.amountOff = amountOff;
    }

    @Override
    public double getAmount() {
        return Math.max(0, wrapped.getAmount() - amountOff);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " - coupon " + code + " (" + amountOff + ")";
    }
}
