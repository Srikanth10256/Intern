import java.util.Scanner;

public class OnlineReservationSystem {
    private static String loggedInUser = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Reservation");
            System.out.println("3. Cancellation");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    if (loggedInUser != null) {
                        makeReservation();
                    } 
                    else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 3:
                    if (loggedInUser != null) {
                        cancelReservation();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the Online Reservation System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String usernameInput = scanner.nextLine();

        System.out.println("Enter your password: ");
        String passwordInput = scanner.nextLine();

        if (usernameInput.equals("user") && passwordInput.equals("password")) {
            loggedInUser = usernameInput;
            System.out.println("Login successful! Welcome, " + loggedInUser + "!");
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private static void makeReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your deatils:");

        String details=scanner.next();

        System.out.println("Enter your train number:");

        String trainnumber=scanner.next();

        System.out.println("Enter your type of seat:");

        String type=scanner.next();

        System.out.println("Enter date of journey:");

        String date=scanner.next();

        System.out.println("Enter place of journey start:");

        String from=scanner.next();

        System.out.println("Enter where you destination:");

        String to=scanner.next();

        System.out.println("Reservation successful! Your details have been recorded.");
    }

    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your PNR number for cancellation: ");
        String pnrNumber = scanner.nextLine();


        System.out.println("Do you want to cancel the reservation? Press 'OK' to confirm.");

        String confirmationInput = scanner.nextLine();
        if (confirmationInput.equalsIgnoreCase("OK"))
        {

            System.out.println("Cancellation successful. Your reservation has been canceled.");
        } 
        else 
        {
            System.out.println("Cancellation aborted.");
        }
    }
}