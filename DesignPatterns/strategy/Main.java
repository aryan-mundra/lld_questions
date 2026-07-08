package strategy;

/**
 * Strategy: pick one algorithm from a family at runtime, and swap it freely
 * without changing the code that uses it.
 */
public class Main {
    public static void main(String[] args) {
        PaymentStrategy strategy = new UpiPayment();   // choose at runtime
        strategy.pay(500);

        strategy = new CreditCardPayment();            // swap the strategy
        strategy.pay(1200);
    }
}
