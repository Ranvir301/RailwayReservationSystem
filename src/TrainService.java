public class TrainService {

    public void addTrain(Train train) {

        for (Train t : TrainData.trains) {
            if (t.getTrainId() == train.getTrainId()) {
                System.out.println("Train ID already exists!");
                return;
            }
        }

        TrainData.trains.add(train);
        System.out.println("Train added successfully!");
    }

    public void removeTrain(int trainId) {

        Train train = getTrainById(trainId);

        if (train == null) {
            System.out.println("Train not found!");
            return;
        }

        TrainData.trains.remove(train);
        System.out.println("Train removed successfully!");
    }

    public void displayAllTrains() {

        for (Train train : TrainData.trains) {
            train.displayTrain();
        }
    }

    public Train getTrainById(int trainId) {

        for (Train train : TrainData.trains) {
            if (train.getTrainId() == trainId) {
                return train;
            }
        }

        return null;
    }
    public void searchTrain(Scanner sc) {

        System.out.print("Enter Source: ");
        String source = sc.nextLine().trim();

        System.out.print("Enter Destination: ");
        String destination = sc.nextLine().trim();

        boolean found = false;

        for (Train train : TrainData.trains) {

            if (train.getSource().equalsIgnoreCase(source)
                    && train.getDestination().equalsIgnoreCase(destination)) {

                train.displayTrain();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No trains found for this route!");
        }
    }
}

