package decorator;

public class Sugar extends AddOn {
    public Sugar(Coffee coffee) { super(coffee); }
    public String description() { return coffee.description() + " + Sugar"; }
    public double cost() { return coffee.cost() + 5; }
}
