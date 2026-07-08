public class Milk extends AddOn {
    public Milk(Coffee coffee) { super(coffee); }
    public String description() { return coffee.description() + " + Milk"; }
    public double cost() { return coffee.cost() + 10; }
}
