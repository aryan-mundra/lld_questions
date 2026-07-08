import enums.CompartmentClass;
import model.Route;
import model.Station;
import model.Train;
import service.FareService;

/**
 * Demo: build a route A-B-C-D-E with segment distances, then price a journey
 * for all three compartment classes based on the distance travelled.
 */
public class Main {
    public static void main(String[] args) {
        // Build the route: each station's distance is from the PREVIOUS one.
        Route route = new Route();
        route.addStation(new Station("A"), 0);   // start
        route.addStation(new Station("B"), 50);  // 50 km from start
        route.addStation(new Station("C"), 30);  // 80
        route.addStation(new Station("D"), 40);  // 120
        route.addStation(new Station("E"), 60);  // 180

        Train train = new Train("Express-101", route);
        FareService fareService = new FareService(train);

        printFares(fareService, "B", "D");   // 70 km
        printFares(fareService, "A", "E");   // 180 km (full route)
    }

    private static void printFares(FareService fareService, String from, String to) {
        int distance = fareService.distance(from, to);
        System.out.println("\nJourney " + from + " -> " + to + "  (" + distance + " km)");
        for (CompartmentClass cls : CompartmentClass.values()) {
            System.out.printf("  %-13s ₹%.2f%n", cls, fareService.fare(from, to, cls));
        }
    }
}
