import java.util.Scanner;

class Video {
    private String title;
    private boolean checkedOut;
    private double averageRating;
    private int numberOfRatings;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.averageRating = 0.0;
        this.numberOfRatings = 0;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnVideo() {
        checkedOut = false;
    }

    public void receiveRating(int rating) {
        averageRating = (averageRating * numberOfRatings + rating) / (numberOfRatings + 1);
        numberOfRatings++;
    }

    public double getAverageRating() {
        return averageRating;
    }
}

class VideoStore {
    private Video[] inventory;

    public VideoStore() {
        this.inventory = new Video[100];
    }

    public void addVideo(String title) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = new Video(title);
                System.out.println("Video '" + title + "' added to the inventory.");
                return;
            }
        }
        System.out.println("Error: Inventory is full. Cannot add video '" + title + "'.");
    }

    public void checkOut(String title) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title) && !video.isCheckedOut()) {
                video.checkOut();
                System.out.println("Video '" + title + "' checked out.");
                return;
            }
        }
        System.out.println("Error: Video '" + title + "' not found or already checked out.");
    }

    public void returnVideo(String title) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title) && video.isCheckedOut()) {
                video.returnVideo();
                System.out.println("Video '" + title + "' returned.");
                return;
            }
        }
        System.out.println("Error: Video '" + title + "' not found or not checked out.");
    }

    public void receiveRating(String title, int rating) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title)) {
                video.receiveRating(rating);
                System.out.println("Rating of " + rating + " received for video '" + title + "'.");
                return;
            }
        }
        System.out.println("Error: Video '" + title + "' not found.");
    }

    public void listInventory() {
        System.out.println("Current Inventory:");
        for (Video video : inventory) {
            if (video != null) {
                System.out.println("Title: " + video.getTitle() +
                        ", Checked Out: " + video.isCheckedOut() +
                        ", Average Rating: " + video.getAverageRating());
            }
        }
    }
}

public class Exp2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoStore videoStore = new VideoStore();
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a video");
            System.out.println("2. Check out a video");
            System.out.println("3. Return a video");
            System.out.println("4. Receive a rating");
            System.out.println("5. List inventory");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter the video title: ");
                    String title = scanner.nextLine();
                    videoStore.addVideo(title);
                    break;
                case 2:
                    System.out.print("Enter the video title: ");
                    title = scanner.nextLine();
                    videoStore.checkOut(title);
                    break;
                case 3:
                    System.out.print("Enter the video title: ");
                    title = scanner.nextLine();
                    videoStore.returnVideo(title);
                    break;
                case 4:
                    System.out.print("Enter the video title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter the rating: ");
                    int rating = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    videoStore.receiveRating(title, rating);
                    break;
                case 5:
                    videoStore.listInventory();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
