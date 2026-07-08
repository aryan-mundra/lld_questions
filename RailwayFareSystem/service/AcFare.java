package service;

/**
 * AC has a DIFFERENT shape of formula: a fixed base charge plus a per-km rate.
 * (This is exactly why Strategy fits — the classes aren't just different
 * multipliers, they can have genuinely different formulas.)
 */
public class AcFare implements FareStrategy {
    public double calculate(int distanceKm) {
        return 50 + distanceKm * 3.0; // base ₹50 + ₹3/km
    }
}
