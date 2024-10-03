
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

    // Kiểm tra nhập lựa chọn y/n
    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    // Kiểm tra mã code đã tồn tại hay chưa
    public static boolean checkCodeExist(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }

    // Kiểm tra sự trùng lặp thông tin bác sĩ
    public static boolean checkDuplicate(ArrayList<Doctor> ld, String code, String name, String specialization, int availability) {
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())
                && name.equalsIgnoreCase(doctor.getName())
                && specialization.equalsIgnoreCase(doctor.getSpecialization())
                && availability == doctor.getAvailability()) {
                return false;
            }
        }
        return true;
    }

    // Kiểm tra thông tin có thay đổi hay không
    public static boolean checkChangeInfo(Doctor doctor, String code, String name, String specialization, int availability) {
        return !(doctor.getCode().equalsIgnoreCase(code)
                && doctor.getName().equalsIgnoreCase(name)
                && doctor.getSpecialization().equalsIgnoreCase(specialization)
                && doctor.getAvailability() == availability);
    }
}
