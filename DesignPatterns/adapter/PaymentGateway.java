package adapter;

/** The interface OUR app expects to use everywhere. */
public interface PaymentGateway {
    void pay(int rupees);
}
