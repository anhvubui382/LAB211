import java.util.ArrayList;
import java.util.Scanner;

public class DoctorList {
    private ArrayList<Doctor> doctors;

    public DoctorList() {
        this.doctors = new ArrayList<>(); // Initialize the list
    }

    // Method to add a doctor to the list
    public boolean addDoctor(Doctor newDoctor) {
        try {
            doctors.add(newDoctor);
            System.out.println("Doctor added successfully: " + newDoctor);
            return true;
        } catch (Exception e) {
            System.out.println("Error adding doctor: " + e.getMessage());
            return false;
        }
    }

    // Method to display all doctors
    public void displayDoctors() {
        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    // Method to find a doctor by code
    public Doctor findDoctorByCode(String code) {
        for (Doctor doctor : doctors) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor; // Return the doctor if found
            }
        }
        return null; // Return null if no doctor is found
    }

    // Method to delete a doctor by code
    public boolean deleteDoctor(String code) {
        Doctor doctorToRemove = findDoctorByCode(code);
        if (doctorToRemove != null) {
            doctors.remove(doctorToRemove); // Remove the doctor from the list
            System.out.println("Doctor deleted successfully: " + doctorToRemove);
            return true; // Return true if removed successfully
        }
        System.out.println("Doctor with code " + code + " not found.");
        return false; // Return false if no doctor was found to remove
    }

    // Method to search for a doctor by code and display their information
    public void searchDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the doctor code to search: ");
        String code = scanner.nextLine();

        Doctor foundDoctor = findDoctorByCode(code);
        if (foundDoctor != null) {
            System.out.println("Doctor found: " + foundDoctor);
        } else {
            System.out.println("No doctor found with code: " + code);
        }
    }
}
