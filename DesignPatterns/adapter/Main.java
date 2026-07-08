/**
 * Adapter: lets two incompatible interfaces work together. Our app only knows
 * PaymentGateway; the adapter quietly bridges it to the third-party PayPal.
 */
public class Main {
    public static void main(String[] args) {
        PaymentGateway gateway = new PayPalAdapter();  // app sees only its own interface
        gateway.pay(830);                              // -> PayPal charged $10.0
    }
}
