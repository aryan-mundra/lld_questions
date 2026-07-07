package enums;

/**
 * Physical size categories of parking spots.
 * Rule here is STRICT: each spot size accepts exactly one vehicle type
 * (SMALL → motorcycle, MEDIUM → car, LARGE → truck). See VehicleType.
 */
public enum SpotType {
    SMALL,
    MEDIUM,
    LARGE
}
