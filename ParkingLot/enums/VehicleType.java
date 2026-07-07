package enums;

/**
 * The kinds of vehicles the lot supports.
 * Each type is bound to the ONE spot type it's allowed to use:
 * motorcycle → SMALL, car → MEDIUM, truck → LARGE (strict, exact match).
 * Storing the required spot on the enum keeps the "fits?" check to one line.
 */
public enum VehicleType {
    MOTORCYCLE(SpotType.SMALL),
    CAR(SpotType.MEDIUM),
    TRUCK(SpotType.LARGE);

    private final SpotType requiredSpot;

    VehicleType(SpotType requiredSpot) {
        this.requiredSpot = requiredSpot;
    }

    public SpotType getRequiredSpot() {
        return requiredSpot;
    }
}
