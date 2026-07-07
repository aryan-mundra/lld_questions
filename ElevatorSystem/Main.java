import enums.Direction;
import model.Elevator;
import model.Request;
import service.ElevatorSystem;
import service.NearestElevatorStrategy;

/**
 * Demo: two elevators, a few requests, then run the simulation tick by tick.
 * Watch how the "nearest" strategy assigns cars and how one car serves several
 * stops in order as it travels.
 */
public class Main {
    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem(new NearestElevatorStrategy());
        system.addElevator(new Elevator(1, 0)); // starts on floor 0
        system.addElevator(new Elevator(2, 6)); // starts on floor 6

        // Requests come in (floor + direction of the hall call)
        system.requestElevator(new Request(2, Direction.UP));   // closest to E1
        system.requestElevator(new Request(5, Direction.DOWN)); // closest to E2
        system.requestElevator(new Request(3, Direction.UP));   // E1 will serve on the way up

        // Run the clock until everything is served
        int t = 0;
        while (system.anyWork() && t < 20) {
            t++;
            System.out.println("t=" + t);
            system.step();
        }
        System.out.println("All requests served.");
    }
}
