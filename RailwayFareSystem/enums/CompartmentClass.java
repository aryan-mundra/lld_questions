package enums;

/**
 * The three compartment types a train offers. The actual fare formula for each
 * lives in its own FareStrategy (see the service package), so this enum just
 * names the choices.
 */
public enum CompartmentClass {
    SECOND_CLASS,
    FIRST_CLASS,
    AC
}
