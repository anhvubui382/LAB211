import java.util.ArrayList;
import java.util.Scanner;

public class Validate {

    private final static Scanner in = new Scanner(System.in);

    // Check user input number within a range
    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    // Check user input string
    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    // Check user input integer
    public static int checkInputInt() {
        while (true) {
            try {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Please input number integer");
                System.out.print("Enter again: ");
            }
        }
    }

    // Check if availability is >= 0
    public static int checkAvailability() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Availability must be a positive number");
                System.out.print("Enter again: ");
            }
        }
    }

    // Check if code exists
    public static boolean checkCodeExist(ArrayList<Doctor> doctorList, String code) {
        for (Doctor doctor : doctorList) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }
}
