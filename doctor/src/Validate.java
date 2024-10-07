
import java.util.ArrayList;
import java.util.Scanner;


public class Validate {

    private final static Scanner in = new Scanner(System.in);

    // Kiểm tra nhập số nguyên trong một giới hạn
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

    // Kiểm tra nhập chuỗi không rỗng
    public static String checkInputString() {
        
            String result = in.nextLine().trim();
            
                return result;
      
    }

    // Kiểm tra nhập số nguyên
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

}
