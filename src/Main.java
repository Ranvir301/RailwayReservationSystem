import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static UserService userService = new UserService();
    static TrainService trainService = new TrainService();
    static BookingService bookingService = new BookingService();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n RAILWAY RESERVATION SYSTEM ");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    System.out.println("Thank you for using Railway System!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void register() {

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        userService.registerUser(name, email, password, phone);
    }

    static void login() {

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        User user = userService.loginUser(email, password);

        if (user == null) {
            System.out.println("Invalid email or password!");
            return;
        }

        System.out.println("Welcome, " + user.getName());

        if (user instanceof Admin) {
            adminMenu();
        } else {
            userMenu(user);
        }
    }

    // USER MENU

    static void userMenu(User user) {

        while (true) {

            System.out.println("\n USER MENU ");
            System.out.println("1. View All Trains");
            System.out.println("2. Search Train");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. View My Bookings");
            System.out.println("6. Multithreading Demo");
            System.out.println("7. Logout");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    trainService.displayAllTrains();
                    break;

                case 2:
                    trainService.searchTrain(sc);
                    break;

                case 3:
                    bookTicket(user);
                    break;

                case 4:
                    System.out.print("Enter PNR: ");
                    String pnr = sc.nextLine();

                    bookingService.cancelTicket(pnr, user.getUserId());
                    break;

                case 5:
                    bookingService.displayBookingHistory(user.getUserId());
                    break;

                case 6:
                    multithreadingDemo(user);
                    break;

                case 7:
                    System.out.println("Logged out!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // BOOK TICKET

    static void bookTicket(User user) {

        System.out.print("Enter Train ID: ");
        int trainId = sc.nextInt();
        sc.nextLine();

        Train train = trainService.getTrainById(trainId);

        if (train == null) {
            System.out.println("Train not found!");
            return;
        }

        System.out.print("Passenger Name: ");
        String name = sc.nextLine();

        System.out.print("Passenger Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Passenger Gender: ");
        String gender = sc.nextLine();

        Passenger passenger = new Passenger(name, age, gender);

        bookingService.bookTicket(user, train, passenger);
        System.out.println("Ticket booking process completed.");
    }

    // ADMIN MENU

    static void adminMenu() {

        while (true) {

            System.out.println("\n ADMIN MENU ");
            System.out.println("1. Add Train");
            System.out.println("2. Remove Train");
            System.out.println("3. View All Trains");
            System.out.println("4. View All Bookings");
            System.out.println("5. View All Users");
            System.out.println("6. Logout");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addTrain();
                    break;

                case 2:
                    System.out.print("Enter Train ID to remove: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    trainService.removeTrain(id);
                    break;

                case 3:
                    trainService.displayAllTrains();
                    break;

                case 4:
                    bookingService.displayAllBookings();
                    break;

                case 5:
                    userService.displayAllUsers();
                    break;

                case 6:
                    System.out.println("Admin logged out!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ADD TRAIN

    static void addTrain() {

        System.out.print("Enter Train ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Train Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Source: ");
        String source = sc.nextLine();

        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();

        System.out.print("Enter Departure Time: ");
        String departure = sc.nextLine();

        System.out.print("Enter Arrival Time: ");
        String arrival = sc.nextLine();

        System.out.print("Enter Total Seats: ");
        int seats = sc.nextInt();

        System.out.print("Enter Fare: ");
        double fare = sc.nextDouble();
        sc.nextLine();

        Train train = new Train(id, name, source, destination,
                departure, arrival, seats, fare);

        trainService.addTrain(train);
    }

    // MULTITHREADING DEMO

    static void multithreadingDemo(User user) {

        System.out.print("Enter Train ID: ");
        int trainId = sc.nextInt();
        sc.nextLine();

        Train train = trainService.getTrainById(trainId);

        if (train == null) {
            System.out.println("Train not found!");
            return;
        }

        
        System.out.print("Enter first passenger name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter first passenger age: ");
        int age1 = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter first passenger gender: ");
        String gender1 = sc.nextLine();



        System.out.print("Enter second passenger name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter second passenger age: ");
        int age2 = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter second passenger gender: ");
        String gender2 = sc.nextLine();

        Passenger p1 = new Passenger(name1, age1, gender1);
        Passenger p2 = new Passenger(name2, age2, gender2);

        BookingTask task1 = new BookingTask(user, train, p1, bookingService);
        BookingTask task2 = new BookingTask(user, train, p2, bookingService);

        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!");
            Thread.currentThread().interrupt();
        }

        System.out.println("");
    }
} 
    

