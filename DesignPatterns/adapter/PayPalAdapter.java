/**
 * The Adapter: makes the incompatible PayPal class look like our PaymentGateway.
 * It implements our interface and translates the call (rupees -> dollars, and
 * pay() -> sendDollars()) to the adaptee underneath.
 */
public class PayPalAdapter implements PaymentGateway {
    private final ThirdPartyPayPal paypal = new ThirdPartyPayPal();

    public void pay(int rupees) {
        double dollars = rupees / 83.0;      // translate the difference
        paypal.sendDollars(dollars);
    }
}
