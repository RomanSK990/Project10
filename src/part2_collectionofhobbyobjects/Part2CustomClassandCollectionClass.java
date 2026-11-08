package part2_collectionofhobbyobjects;

import java.util.Scanner;

class Game {

    private String title;
    private String genre;
    private int releaseYear;
    private double rating;

    public Game (String title, String genre, int releaseYear, double rating) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating <= 100 && rating >= 0) {
            this.rating = rating;
        }
    }
    // Method to perform output of description
    public void printDescription() {
        System.out.println("Title: " + getTitle());
        System.out.println("Genre: " + getGenre());
        System.out.println("ReleaseYear: " + getReleaseYear());
        System.out.println("Rating: " + getRating() + "/100");
    }
}
class GameCollection {
    private int count;
    private Game[] games;

    public GameCollection(int capacity) {
        this.count = 0;
        this.games = new Game[capacity];
    }

    public void add(Game game) {
        if (count < games.length) {
            games[count] = game;
            count++;
        }
        else {
            System.out.println("No space left");
        }
    }
    public void printOne(int i) {
        if (i >= 0 && i < count) {
            games[i].printDescription();
        }
        else {
            System.out.println("Invalid index");
        }
    }
    public void print() {
        for (int i = 0; i < count; i++) {
            printOne(i);
        }
    }
    public void find(String namesearch) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (namesearch.equals(games[i].getTitle())) {
                printOne(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Game not found");
        }
    }
    public void sort() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (games[j].getRating() < games[j + 1].getRating()) {
                    Game temp = games[j];
                    games[j] = games[j + 1];
                    games[j + 1] = temp;
                }
            }
        }
        System.out.println("Games sorted by rating");
    }
    public void searchYear(int year) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (year == games[i].getReleaseYear()) {
                printOne(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Game not found");
        }
    }
}
public class Part2CustomClassandCollectionClass {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        GameCollection collection = new GameCollection(100);

        int choice;

        do {
            System.out.println("Welcome to the game database!");
            System.out.println("Choose an option:");
            System.out.println("1 - Add games to collection");
            System.out.println("2 - Print all games");
            System.out.println("3 - Sort games by rating");
            System.out.println("4 - Search games by title");
            System.out.println("5 - Search games by release year");
            System.out.println("0 - Exit");

            System.out.print("Your choice: ");
            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    inputItems(collection);
                    break;

                case 2:
                    collection.print();
                    break;

                case 3:
                    sort(collection);
                    collection.print();
                    break;

                case 4:
                    search(collection);
                    break;

                case 5:
                    searchYear(collection);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } while (choice != 0);
    }

    public static void inputItems(GameCollection collection) {

        String answer;

        do {
            System.out.println("Enter game information:");

            System.out.print("Title: ");
            String title = in.nextLine();

            System.out.print("Genre: ");
            String genre = in.nextLine();

            System.out.print("Release year: ");
            int releaseYear = in.nextInt();

            System.out.print("Rating (0-100): ");
            double rating = in.nextDouble();
            in.nextLine();

            Game game = new Game(title, genre, releaseYear, rating);
            collection.add(game);

            System.out.print("Add another game? (yes/no): ");
            answer = in.nextLine();

        } while (answer.equalsIgnoreCase("yes"));
    }

    public static void search(GameCollection collection) {

        System.out.print("Enter game title: ");
        String title = in.nextLine();
        collection.find(title);
    }

    public static void searchYear(GameCollection collection) {
        System.out.print("Enter release year: ");
        int year = in.nextInt();
        in.nextLine();

        collection.searchYear(year);
    }

    public static void sort(GameCollection collection) {
        collection.sort();
    }
}
