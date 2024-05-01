import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModoGerente {

    private static List<Exibicao> movieShowings = new ArrayList<>();

    static void enterManagerMode(Scanner scanner) {

        boolean managerSession = true;
        while (managerSession) {
            System.out.println("\nManager Menu:");
            System.out.println("1. Update Showings");
            System.out.println("2. Generate Reports");
            System.out.println("3. Logout");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    updateShowings(scanner);
                    break;
                case 2:
                    generateReports(scanner);
                    break;
                case 3:
                    managerSession = false;
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void updateShowings(Scanner scanner) {
        System.out.println("Updating showings...");
        System.out.println("1. Add new showing");
        System.out.println("2. Modify existing showing");
        System.out.println("3. Remove existing showing");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addNewShowing(scanner);
                break;
            case 2:
                modifyExistingShowing(scanner);
                break;
            case 3:
                removeExistingShowing(scanner);
                break;
            default:
                System.out.println("Invalid option, please try again.");
        }
    }

    private static void addNewShowing(Scanner scanner) {
        System.out.println("Adding new showing...");
        System.out.print("Enter cinema hall name: ");
        String hallName = scanner.next();
        System.out.print("Enter room type (BASIC, THREE_D, VIP): ");
        TipoDeSala roomType = TipoDeSala.valueOf(scanner.next().toUpperCase());
        System.out.print("Enter capacity: ");
        int capacity = scanner.nextInt();
        System.out.print("Enter movie name: ");
        String movieName = scanner.next();
        System.out.print("Enter show time: ");
        String showTime = scanner.next();

        SalaDeCinema cinemaHall = new SalaDeCinema(hallName, roomType, capacity);
        Exibicao newShowing = new Exibicao(cinemaHall, movieName, showTime);
        movieShowings.add(newShowing);

        System.out.println("New showing added successfully.");
    }

    private static void modifyExistingShowing(Scanner scanner) {
        System.out.println("Modifying existing showing...");
        // Display existing showings
        displayMovieShowings();

        System.out.print("Select the index of the showing to modify: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < movieShowings.size()) {
            Exibicao showingToModify = movieShowings.get(index);

            System.out.print("Enter new movie name (press Enter to keep unchanged): ");
            String newMovieName = scanner.next();
            if (!newMovieName.isEmpty()) {
                showingToModify.setNomeFilme(newMovieName);
            }

            System.out.print("Enter new show time (press Enter to keep unchanged): ");
            String newShowTime = scanner.next();
            if (!newShowTime.isEmpty()) {
                showingToModify.setHorarioFilmme(newShowTime);
            }

            System.out.println("Showing modified successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void removeExistingShowing(Scanner scanner) {
        System.out.println("Removing existing showing...");
        // Display existing showings
        displayMovieShowings();

        System.out.print("Select the index of the showing to remove: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < movieShowings.size()) {
            movieShowings.remove(index);
            System.out.println("Showing removed successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void displayMovieShowings() {
        System.out.println("Existing Showings:");
        for (int i = 0; i < movieShowings.size(); i++) {
            System.out.println(i + ". " + movieShowings.get(i).getNomeFilme() + " - " +
                    movieShowings.get(i).getSalao().getName() + " - " +
                    movieShowings.get(i).getHorarioFilmme());
        }

    }

    private static void generateReports (Scanner scanner){
        System.out.println("Generating reports...");
        // Add logic to generate sales reports
    }

}