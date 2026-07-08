package service;

/** Higher per-km rate than second class. */
public class FirstClassFare implements FareStrategy {
    public double calculate(int distanceKm) {
        return distanceKm * 2.5;
    }
}
