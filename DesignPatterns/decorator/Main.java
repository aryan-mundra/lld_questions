/**
 * Decorator: attach extra behavior by wrapping an object in layers, each
 * sharing the same interface. Here we stack Milk and Sugar onto a Coffee.
 */
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();  // Coffee = 50
        coffee = new Milk(coffee);           // + Milk = 60
        coffee = new Sugar(coffee);          // + Sugar = 65

        System.out.println(coffee.description() + " = " + coffee.cost());
    }
}
