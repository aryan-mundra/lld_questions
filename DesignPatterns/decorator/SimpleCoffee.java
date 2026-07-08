package decorator;

/** The base component that decorators wrap. */
public class SimpleCoffee implements Coffee {
    public String description() { return "Coffee"; }
    public double cost() { return 50; }
}
