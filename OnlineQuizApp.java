import java.util.Scanner;

public class OnlineQuizApp {
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser;

    public static void main(String[] args) {
        System.out.println("Welcome to the Online Quiz App!");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Login");
            System.out.println("2. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Thank you for using the Online Quiz App. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Assume a simple username/password check for demonstration purposes
        if (isValidUser(username, password)) {
            currentUser = new User(username);
            quizMenu();
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    private static boolean isValidUser(String username, String password) {
        // In a real-world scenario, validate against a database or other secure means
        return username.equals("Elephant") && password.equals("Eagle");
    }

    private static void quizMenu() {
        while (true) {
            System.out.println("\nQuiz Menu:");
            System.out.println("1. Update Profile and Password");
            System.out.println("2. Start Quiz");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    updateProfile();
                    break;
                case 2:
                    startQuiz();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    currentUser = null;
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void updateProfile() {
        System.out.println("\nUpdate Profile and Password:");
        System.out.print("Enter your new password: ");
        String newPassword = scanner.nextLine();
        currentUser.setPassword(newPassword);
        System.out.println("Profile and password updated successfully.");
    }

    private static void startQuiz() {
        System.out.println("\nStarting Quiz...");

        // Assume a set of MCQs for the quiz
        String[] questions = {"What is the capital of France?", "Which programming language is this project written in?"};
        String[][] options = {{"A. Paris", "B. London", "C. Berlin", "D. Rome"},
                {"A. Java", "B. Python", "C. C++", "D. JavaScript"}};
        int[] correctAnswers = {0, 0}; // Index of correct options

        int score = 0;
        int totalQuestions = questions.length;
        int timer = 60; // Timer in seconds

        while (timer > 0) {
            System.out.println("\nTimer: " + timer + " seconds remaining");
            for (int i = 0; i < totalQuestions; i++) {
                System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
                for (String option : options[i]) {
                    System.out.println(option);
                }
                System.out.print("Your choice: ");
                char userChoice = scanner.nextLine().toUpperCase().charAt(0);

                if (userChoice - 'A' == correctAnswers[i]) {
                    score++;
                }
            }
            timer -= 10; // Assume each question takes 10 seconds
            System.out.println("Auto-submitting answers...");
            break; // For demonstration purposes, break after the first iteration
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your score: " + score + "/" + totalQuestions);
    }
}

class User {
    private String username;
    private String password;

    public User(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
