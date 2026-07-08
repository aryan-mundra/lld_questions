package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * An ordered list of stations with the distance of each from the start.
 *
 * The trick for "distance between any two stations": store each station's
 * cumulative km from the origin. Then distance(from, to) is simply the
 * DIFFERENCE of the two cumulative values — no need to add up segments each
 * time. abs() lets it work in either travel direction.
 *
 *   A(0) --50--> B(50) --30--> C(80) --40--> D(120) --60--> E(180)
 *   distance(B, D) = 120 - 50 = 70 km
 */
public class Route {
    private final List<Station> stations = new ArrayList<>();
    private final Map<String, Integer> kmFromStart = new LinkedHashMap<>();
    private int total = 0;

    /** Add the next station, giving its distance from the PREVIOUS one (0 for the first). */
    public void addStation(Station station, int distanceFromPrevious) {
        total += distanceFromPrevious;
        stations.add(station);
        kmFromStart.put(station.getName(), total);
    }

    public int distanceBetween(String fromName, String toName) {
        Integer from = kmFromStart.get(fromName);
        Integer to = kmFromStart.get(toName);
        if (from == null || to == null) {
            throw new IllegalArgumentException("Station not on this route: "
                    + (from == null ? fromName : toName));
        }
        return Math.abs(to - from);
    }

    public List<Station> getStations() { return stations; }
    public int getKmFromStart(String name) { return kmFromStart.get(name); }
}
