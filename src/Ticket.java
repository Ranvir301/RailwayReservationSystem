public class Ticket {

    private String pnr;
    private int userId;
    private Train train;
    private Passenger passenger;
    private int seatNumber;
    private double fare;
    private String status;

    public Ticket(String pnr, int userId, Train train,
                 Passenger passenger, int seatNumber, double fare) {

        this.pnr = pnr;
        this.userId = userId;
        this.train = train;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
        this.fare = fare;
        this.status = "CONFIRMED";
    }

    public String getPnr() {
        return pnr;
    }

    public int getUserId() {
        return userId;
    }

    public Train getTrain() {
        return train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public double getFare() {
        return fare;
    }

    public String getStatus() {
        return status;
    }

    public void cancel() {
        status = "CANCELLED";
    }

    public void displayTicket() {

        System.out.println("\n==================================");
        System.out.println("          RAILWAY TICKET");
        System.out.println("==================================");

        System.out.println("PNR          : " + pnr);
        System.out.println("Passenger    : " + passenger.getName());
        System.out.println("Age          : " + passenger.getAge());

        System.out.println("----------------------------------");

        System.out.println("Train        : " + train.getTrainName());
        System.out.println("Train ID     : " + train.getTrainId());
        System.out.println("Route        : " + train.getSource()+ " -> " + train.getDestination());
        System.out.println("Departure    : " + train.getDepartureTime());

        System.out.println("----------------------------------");

        System.out.println("Seat Number  : " + seatNumber);
        System.out.println("Fare         : Rs. " + fare);
        System.out.println("Status       : " + status);

        System.out.println("==================================");
    }
}
