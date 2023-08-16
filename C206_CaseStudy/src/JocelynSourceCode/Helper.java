package JocelynSourceCode;
import java.util.Scanner;
//comments
public class Helper {
    private static Scanner scanner = new Scanner(System.in);

    // Method to read an integer input from the user
    public static int readInt(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character from the buffer
        return input;
    }

    // Method to read a double input from the user
    public static double readDouble(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid double.");
            scanner.next();
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); // Clear the newline character from the buffer
        return input;
    }

    // Method to read a string input from the user
    public static String readString(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }
}
