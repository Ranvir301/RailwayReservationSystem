public class BookingTask implements Runnable {

    private User user;
    private Train train;
    private Passenger passenger;
    private BookingService bookingService;

    public BookingTask(User user, Train train,
                      Passenger passenger, BookingService bookingService) {

        this.user = user;
        this.train = train;
        this.passenger = passenger;
        this.bookingService = bookingService;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()
                + " is trying to book a ticket for "
                + passenger.getName());

        bookingService.bookTicket(user, train, passenger);
    }
}