
import java.util.ArrayList;

public class TrainData {

    public static ArrayList<Train> trains = new ArrayList<>();

    static {

        trains.add(new Train(101, "Rajdhani Express", "Delhi", "Mumbai",
                "06:00 AM", "08:00 PM", 5, 1500));

        trains.add(new Train(102, "Shatabdi Express", "Delhi", "Jaipur",
                "07:00 AM", "01:00 PM", 3, 800));

        trains.add(new Train(103, "Amritsar Express", "Delhi", "Amritsar",
                "09:00 PM", "06:00 AM", 4, 700));

        trains.add(new Train(104, "Intercity Express", "Jaipur", "Delhi",
                "02:00 PM", "08:00 PM", 5, 600));
    }
}
