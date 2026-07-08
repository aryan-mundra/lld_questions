package strategy;

/**
 * Strategy: pick one algorithm from a family at RUNTIME and swap it freely.
 * The choice (here a String) normally comes from user input or config, so it's
 * only known while the program runs — select() turns it into a strategy object.
 */
public class Main {
    public static void main(String[] args) {
        String chosen = "upi";                        // pretend the user picked this

        PaymentStrategy strategy = select(chosen);    // pick the matching strategy
        strategy.pay(500);                            // runs UpiPayment.pay()

        strategy = select("card");                    // a different runtime choice
        strategy.pay(1200);                           // runs CreditCardPayment.pay()
    }

    // the ONE place that turns a runtime value into a strategy object
    private static PaymentStrategy select(String type) {
        if (type.equals("upi")) {
            return new UpiPayment();
        } else if (type.equals("card")) {
            return new CreditCardPayment();
        } else {
            throw new IllegalArgumentException("Unknown payment: " + type);
        }
    }
}
