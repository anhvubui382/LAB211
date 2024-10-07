

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Doctor> doctorsList = new ArrayList<>();
        boolean running = true;

        while (running) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Doctor.addDoctor(doctorsList);
                    break;
                case 2:
                    Doctor.updateDoctor(doctorsList);
                    break;
                case 3:
                    Doctor.deleteDoctor(doctorsList);
                    break;
                case 4:
                    Doctor.searchDoctor(doctorsList);
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
