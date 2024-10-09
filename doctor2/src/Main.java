

import java.util.ArrayList;

public class Main {
      public static int menu() {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputIntLimit(1, 5);
        return choice;
    }
    public static void main(String[] args) {
        ArrayList<Doctor> doctorsList = new ArrayList<>();
        boolean running = true;

        while (running) {
            int choice = menu();
            switch (choice) {
                case 1:
                    Doctor.addDoctor();
                    break;
                case 2:
                    Doctor.updateDoctor();
                    break;
                case 3:
                    Doctor.deleteDoctor();
                    break;
                case 4:
                    Doctor.searchDoctor();
                    break;
                case 5:
                    running = false; // Thoát khỏi chương trình
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
