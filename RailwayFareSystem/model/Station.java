package model;

/** A stop on the route (e.g. "A", "New Delhi"). Plain data. */
public class Station {
    private final String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
