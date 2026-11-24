import java.util.ArrayList;

public class UserService {

    private ArrayList<User> users = new ArrayList<>();
    private int nextUserId = 2;

    public UserService() {
        // Default admin account
        users.add(new Admin(1, "Admin", "admin@gmail.com", "admin123", "9999999999"));
    }

    public boolean registerUser(String name, String email, String password, String phone) {

        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Email already registered!");
                return false;
            }
        }

        User user = new User(nextUserId, name, email, password, phone);
        users.add(user);
        nextUserId++;

        System.out.println("Registration successful!");
        return true;
    }

    public User loginUser(String email, String password) {

        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)
                    && u.getPassword().equals(password)) {
                return u;
            }
        }

        return null;
    }

    public void displayAllUsers() {

        for (User u : users) {
            u.displayUser();
            System.out.println("--------------------");
        }
    }
}