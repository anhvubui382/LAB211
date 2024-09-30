import java.util.Scanner;

public class Validate {
    private static final Scanner scanner = new Scanner(System.in);

    // Kiểm tra chuỗi nhập vào không được rỗng
    public static String checkInputString() {
        while (true) {
            String result = scanner.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            }
            System.out.print("Input cannot be empty, please enter again: ");
        }
    }

    // Kiểm tra nhập vào số nguyên
    public static int checkInputInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please input a valid integer: ");
            }
        }
    }
}
