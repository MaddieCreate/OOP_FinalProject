import java.util.ArrayList;
import java.util.Scanner;

public class DigitalMuseum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<DigitalCollection> collections = new ArrayList<>();

        System.out.println("Welcome to the Digital Museum Collection Management System!");
        pause();

        System.out.println("How many collections would you like to add?");
        int numCollections = scanner.nextInt();
        scanner.nextLine();

        clearConsole();

        for (int i = 0; i < numCollections; i++) {
            System.out.println("Enter details for collection " + (i + 1) + ":");
            System.out.println("Choose type: \n1. Artwork | 2. Artifact | 3. Historical Document");
            int type = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();

            System.out.print("Enter Creator: ");
            String creator = scanner.nextLine();

            System.out.print("Enter Description: ");
            String description = scanner.nextLine();

            switch (type) {
                case 1 -> {
                    System.out.print("Enter Year Created: ");
                    int yearCreated = scanner.nextInt();
                    scanner.nextLine(); 
                    collections.add(new Artwork(title, creator, description, yearCreated));
                }
                case 2 -> {
                    System.out.print("Enter Origin: ");
                    String origin = scanner.nextLine();
                    collections.add(new Artifact(title, creator, description, origin));
                }
                case 3 -> {
                    System.out.print("Enter Year Published: ");
                    int yearPublished = scanner.nextInt();
                    scanner.nextLine();
                    collections.add(new HistoricalDocument(title, creator, description, yearPublished));
                }
                default -> System.out.println("Invalid type. Skipping this collection.");
            }

            pause();
            clearConsole();
        }

        // Display all collections in table format---------------------------------------------------------------------------------------------------------------------
        System.out.println("\t\t\t\t\t\t\t=== Museum Collections ===");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-23s %-20s %-30s %-40s %-20s%n", "Type", "Title", "Creator", "Description", "Additional Info");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        for (DigitalCollection collection : collections) {
            collection.displayDetails();
            pause();
        }

        // Optionally update metadata---------------------------------------------------------------------------------------------------------------------------------
        System.out.println("Would you like to update metadata for any collection? (yes/no)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            System.out.print("Enter the title of the collection to update: ");
            String titleToUpdate = scanner.nextLine();

            boolean found = false;
            for (DigitalCollection collection : collections) {
                if (collection.getTitle().equalsIgnoreCase(titleToUpdate)) {
                    System.out.print("Enter new metadata information: ");
                    String metadata = scanner.nextLine();
                    collection.updateMetadata(metadata);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Collection not found!");
            }
        }

        System.out.println("Thank you for using the Digital Museum Collection Management System!");
        scanner.close();
    }

    // Utility method to clear the console---------------------------------------------------------------------------------------------------------------------------
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Could not clear console.");
        }
    }

    // Utility method to pause for a short duration---------------------------------------------------------------------------------------------------------------------
    public static void pause() {
        try {
            Thread.sleep(1500); // Pause for 1.5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Abstract class to represent a general digital collection---------------------------------------------------------------------------------------------------------------
abstract class DigitalCollection {
    private String title;
    private String creator;
    private String description;

    public DigitalCollection(String title, String creator, String description) {
        this.title = title;
        this.creator = creator;
        this.description = description;
    }

    public abstract void displayDetails();

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public String getDescription() {
        return description;
    }

    public void updateMetadata(String additionalInfo) {
        System.out.println("Updating metadata for: " + title);
        System.out.println("Additional Info: " + additionalInfo);
    }
}

// Artwork class------------------------------------------------------------------------------------------------------------------------------------------------------
class Artwork extends DigitalCollection {
    private int yearCreated;

    public Artwork(String title, String creator, String description, int yearCreated) {
        super(title, creator, description);
        this.yearCreated = yearCreated;
    }

    @Override
    public void displayDetails() {
        System.out.printf("%-23s %-20s %-30s %-40s %-20s%n", 
                "Artwork", 
                getTitle(), 
                getCreator(), 
                getDescription(),
                "Year Created: " + yearCreated);
    }
}

// Artifact class--------------------------------------------------------------------------------------------------------------------------------------------------
class Artifact extends DigitalCollection {
    private String origin;

    public Artifact(String title, String creator, String description, String origin) {
        super(title, creator, description);
        this.origin = origin;
    }

    @Override
    public void displayDetails() {
        System.out.printf("%-23s %-20s %-30s %-40s %-20s%n", 
                "Artifact", 
                getTitle(), 
                getCreator(), 
                getDescription(),
                "Origin: " + origin);
    }
}

// HistoricalDocument class-------------------------------------------------------------------------------------------------------------------------------------------
class HistoricalDocument extends DigitalCollection {
    private int yearPublished;

    public HistoricalDocument(String title, String creator, String description, int yearPublished) {
        super(title, creator, description);
        this.yearPublished = yearPublished;
    }

    @Override
    public void displayDetails() {
        System.out.printf("%-23s %-20s %-30s %-40s %-20s%n", 
                "Historical Document", 
                getTitle(), 
                getCreator(), 
                getDescription(),
                "Year Published: " + yearPublished);
    }
}
