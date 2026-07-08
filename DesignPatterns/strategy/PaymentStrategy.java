/** The contract: a family of interchangeable "how to pay" algorithms. */
public interface PaymentStrategy {
    void pay(int amount);
}
