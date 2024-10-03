
import java.util.ArrayList;
import java.util.Scanner;

public class Validate {

    private final static Scanner in = new Scanner(System.in);

    // Kiểm tra đầu vào số nguyên trong khoảng
    public int checkInputIntLimit(int min, int max) {
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

    // Kiểm tra chuỗi đầu vào
    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Input must not be empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    // Kiểm tra xem id có tồn tại hay không
    public boolean checkIdExist(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return true;
            }
        }
        return false;
    }

    // Kiểm tra mức lương nhập vào phải lớn hơn 0
    public int checkInputSalary() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Salary must be greater than 0");
                System.out.print("Enter again: ");
            }
        }
    }

    // Kiểm tra mức lương mới phải cao hơn mức lương hiện tại
    public int checkInputSalaryHigher(int currentSalary) {
        while (true) {
            int salaryUpdate = checkInputSalary();
            if (salaryUpdate <= currentSalary) {
                System.err.println("New salary must be higher than current salary.");
                System.out.print("Enter again: ");
            } else {
                return salaryUpdate;
            }
        }
    }

    // Kiểm tra mức lương mới phải thấp hơn mức lương hiện tại
    public int checkInputSalaryLower(int currentSalary) {
        while (true) {
            int salaryUpdate = checkInputSalary();
            if (salaryUpdate >= currentSalary) {
                System.err.println("New salary must be lower than current salary.");
                System.out.print("Enter again: ");
            } else {
                return salaryUpdate;
            }
        }
    }
}
