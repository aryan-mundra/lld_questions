package service;

/**
 * A fare formula: given the distance in km, return the fare. Each compartment
 * class has its own implementation (Strategy pattern), so a class's pricing can
 * change — or a new class be added — without touching the others.
 */
public interface FareStrategy {
    double calculate(int distanceKm);
}
