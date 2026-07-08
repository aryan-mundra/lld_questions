package enums;

/**
 * Outcome of a booking attempt. FAILED covers "seat already taken" (e.g. lost
 * a race for the last seat) — an expected result, not a crash.
 */
public enum BookingStatus {
    CONFIRMED,
    FAILED
}
