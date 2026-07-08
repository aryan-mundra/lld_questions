import java.util.ArrayList;
import java.util.List;

import enums.SeatType;
import model.Movie;
import model.Screen;
import model.Seat;
import model.Show;
import model.User;
import service.BookingService;

/**
 * Demo: book some seats, reject an already-booked one, and finally have TWO
 * threads race for the same last seat — only one wins, proving no double booking.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Build a screen with 5 seats (A1-A3 regular, A4-A5 premium)
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat("A1", SeatType.REGULAR));
        seats.add(new Seat("A2", SeatType.REGULAR));
        seats.add(new Seat("A3", SeatType.REGULAR));
        seats.add(new Seat("A4", SeatType.PREMIUM));
        seats.add(new Seat("A5", SeatType.PREMIUM));

        Screen screen = new Screen("Screen 1", seats);
        Show show = new Show("SH1", new Movie("M1", "Inception"), screen, "6:00 PM");
        BookingService service = new BookingService();

        System.out.println("Available: " + show.availableSeats());

        // Sequential bookings
        service.book(new User("Alice"), show, List.of("A1", "A2"));   // CONFIRMED
        service.book(new User("Bob"), show, List.of("A2", "A3"));     // FAILED (A2 taken)
        System.out.println("Available: " + show.availableSeats());

        // Concurrency: Carol and Dave both go for the last premium seat A5 at once
        System.out.println("\n-- Two users race for seat A5 --");
        User carol = new User("Carol");
        User dave = new User("Dave");
        Thread t1 = new Thread(() -> service.book(carol, show, List.of("A5")));
        Thread t2 = new Thread(() -> service.book(dave, show, List.of("A5")));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Available after race: " + show.availableSeats());
    }
}
