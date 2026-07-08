/**
 * Observer: when one object (the Channel) changes, all its dependents
 * (Subscribers) are notified automatically.
 */
public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel();
        Observer alice = new Subscriber("Alice");
        Observer bob   = new Subscriber("Bob");

        channel.subscribe(alice);
        channel.subscribe(bob);
        channel.upload("Design Patterns in 10 minutes");

        channel.unsubscribe(bob);          // Bob leaves
        channel.upload("LLD Interview Tips"); // only Alice is notified now
    }
}
