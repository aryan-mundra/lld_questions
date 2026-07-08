package model;

/**
 * A train runs along a Route and offers all three compartment classes
 * (SECOND_CLASS, FIRST_CLASS, AC — see the CompartmentClass enum). Which class
 * the passenger picks decides the fare formula.
 */
public class Train {
    private final String name;
    private final Route route;

    public Train(String name, Route route) {
        this.name = name;
        this.route = route;
    }

    public String getName() { return name; }
    public Route getRoute() { return route; }
}
