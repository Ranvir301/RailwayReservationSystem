import java.util.*;

public class BookingService {

   
    private ArrayList<Ticket> tickets = new ArrayList<>();

    private static int pnrCounter = 1001;

    

    private synchronized String generatePNR() {
        return "PNR" + pnrCounter++;
    }

    public void bookTicket(User user, Train train, Passenger passenger) {

        
        int seatNumber = train.bookSeat();

        if (seatNumber == 0) {
            System.out.println("No seats available!");
            return;
        }

        double fare = train.getFare();

        String pnr = generatePNR();

        Ticket ticket = new Ticket(
                pnr,
                user.getUserId(),
                train,
                passenger,
                seatNumber,
                fare
        );

        synchronized (tickets) {
            tickets.add(ticket);
        }

        
        ticket.displayTicket();
    }

    public void cancelTicket(String pnr, int userId) {

        synchronized (tickets) {

            for (Ticket ticket : tickets) {

                if (ticket.getPnr().equalsIgnoreCase(pnr)
                        && ticket.getUserId() == userId
                        && ticket.getStatus().equals("CONFIRMED")) {

                    ticket.cancel();

                    ticket.getTrain().cancelSeat(ticket.getSeatNumber());

                    System.out.println("Ticket cancelled successfully!");
                    System.out.println("Seat is now available again.");
                    return;
                }
            }
        }

        System.out.println("Valid booking not found!");
    }

    public void displayTicket(String pnr) {

        synchronized (tickets) {

            for (Ticket ticket : tickets) {

                if (ticket.getPnr().equalsIgnoreCase(pnr)) {
                    ticket.displayTicket();
                    return;
                }
            }
        }

        System.out.println("Ticket not found!");
    }

    public void displayBookingHistory(int userId) {

        boolean found = false;

        synchronized (tickets) {

            for (Ticket ticket : tickets) {

                if (ticket.getUserId() == userId) {
                    ticket.displayTicket();
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No bookings found!");
        }
    }

    public void displayAllBookings() {

        if (tickets.isEmpty()) {
            System.out.println("No bookings available!");
            return;
        }

        synchronized (tickets) {

            for (Ticket ticket : tickets) {
                ticket.displayTicket();
            }
        }
    }
} 
    

