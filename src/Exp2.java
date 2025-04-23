import java.util.Scanner;

class Video {
    private String title;
    private boolean checkedOut;
    private float rating;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.rating = 0;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public float getRating() {
        return rating;
    }

    public void returnVideo() {
        checkedOut = false;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}

class VideoStore {
    private Video[] videos;
    private int count;

    public VideoStore() {
        videos = new Video[10];
        count = 0;
    }

    public void addVideo(String title) {
        if (count < videos.length) {
            videos[count++] = new Video(title);
        } else {
            System.out.println("Video store is full.");
        }
    }

    public void returnVideo(String title) {
        for (int i = 0; i < count; i++) {
            if (videos[i].getTitle().equals(title) && videos[i].isCheckedOut()) {
                videos[i].returnVideo();
                System.out.println("Returned video: " + title);
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void checkOut(String title) {
        for (int i = 0; i < count; i++) {
            if (videos[i].getTitle().equals(title) && !videos[i].isCheckedOut()) {
                videos[i].checkOut();
                System.out.println("Checked out video: " + title);
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void rateVideo(String title, float rating) {
        for (int i = 0; i < count; i++) {
            if (videos[i].getTitle().equals(title)) {
                videos[i].setRating(rating);
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void showAvailableVideos() {
        for (int i = 0; i < count; i++) {
            if (!videos[i].isCheckedOut()) {
                System.out.println("Title: " + videos[i].getTitle() + ", Rating: " + videos[i].getRating());
            }
        }
    }
}

public class Exp2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoStore store = new VideoStore();

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter video title: ");
            String title = scanner.nextLine();
            System.out.print("Enter rating: ");
            float rating = scanner.nextFloat();
            store.addVideo(title);
            store.rateVideo(title, rating);
            scanner.nextLine(); // consume newline
        }

        System.out.print("Enter video title to rent: ");
        String rentTitle = scanner.nextLine();
        store.checkOut(rentTitle);

        System.out.println("Available videos:");
        store.showAvailableVideos();

        scanner.close();
    }
}
