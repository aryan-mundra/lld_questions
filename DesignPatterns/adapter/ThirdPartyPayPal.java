package adapter;

/**
 * The Adaptee: a third-party class we can't change. It has a DIFFERENT method
 * name and works in dollars — incompatible with our PaymentGateway interface.
 */
public class ThirdPartyPayPal {
    public void sendDollars(double dollars) {
        System.out.println("PayPal charged $" + dollars);
    }
}
