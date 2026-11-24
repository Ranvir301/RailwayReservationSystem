
public class Train {

    private int trainId;
    private String trainName;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double fare;

    private boolean[] bookedSeats;

    public Train(int trainId, String trainName, String source,
                 String destination, String departureTime,
                 String arrivalTime, int totalSeats, double fare) {

        this.trainId = trainId;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.fare = fare;

        bookedSeats = new boolean[totalSeats];
    }

    public int getTrainId() {
        return trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public synchronized int getAvailableSeats() {
        return availableSeats;
    }

    public double getFare() {
        return fare;
    }

    public synchronized int bookSeat() {

        for (int i = 0; i < bookedSeats.length; i++) {

            if (!bookedSeats[i]) {

                bookedSeats[i] = true;
                availableSeats--;

                return i + 1;
            }
        }

        return 0;
    }

    public synchronized void cancelSeat(int seatNumber) {

        if (seatNumber >= 1 && seatNumber <= bookedSeats.length) {

            if (bookedSeats[seatNumber - 1]) {

                bookedSeats[seatNumber - 1] = false;
                availableSeats++;
            }
        }
    }

    public void displayTrain() {

        System.out.println("\n========== TRAIN DETAILS ==========");
        System.out.println("Train ID: " + trainId);
        System.out.println("Train Name: " + trainName);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Arrival Time: " + arrivalTime);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + getAvailableSeats());
        System.out.println("Fare: Rs. " + fare);
        System.out.println("================================");
    }
}
