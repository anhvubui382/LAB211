import java.util.ArrayList;
import java.util.Scanner;

public class Validate {
    private static final Scanner scanner = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        int result = 0;
        boolean valid = false;
        while (!valid) {
            try {
                result = Integer.parseInt(scanner.nextLine());
                if (result < min || result > max) {
                    System.out.printf("Please enter a number between %d and %d: ", min, max);
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an integer: ");
            }
        }
        return result;
    }

    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Cannot be null");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

   
    public static int checkInputInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Please input number integer");
                System.out.print("Enter again: ");
            }
        }
    }
           
    
}
