package service;

/** Cheapest: a flat per-km rate. */
public class SecondClassFare implements FareStrategy {
    public double calculate(int distanceKm) {
        return distanceKm * 1.25;
    }
}
