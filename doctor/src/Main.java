import java.util.HashMap;
import java.util.Scanner;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);
    private static final DoctorHash doctorHash = new DoctorHash();
    

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = Validate.checkInputIntLimit(1, 5);

            try {
                switch (option) {
                    case 1:
                        addDoctor();
                        break;
                    case 2:
                        updateDoctor();
                        break;
                    case 3:
                        deleteDoctor();
                        break;
                    case 4:
                        searchDoctor();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addDoctor() throws Exception {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();

        // Check for duplicate code
        if (!Validate.checkCodeExist(doctorHash.getDoctorList(), code)) {
            throw new Exception("Doctor code already exists.");
        }

        System.out.print("Enter name: ");
        String name = Validate.checkInputString();

        System.out.print("Enter specialization: ");
        String specialization = Validate.checkInputString();

        System.out.print("Enter availability (>=0): ");
        int availability = Validate.checkAvailability();

        Doctor doctor = new Doctor(code, name, specialization, availability);
        doctorHash.addDoctor(doctor);
        System.out.println("Doctor added successfully.");
    }

    private static void updateDoctor() throws Exception {
        System.out.print("Enter code of the doctor to update: ");
        String updateCode = Validate.checkInputString();

        Doctor existingDoctor = doctorHash.searchDoctor(updateCode).get(updateCode);
        if (existingDoctor == null) {
            throw new Exception("Doctor code does not exist.");
        }

        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) existingDoctor.setName(newName);

        System.out.print("Enter new specialization (leave blank to keep current): ");
        String newSpecialization = scanner.nextLine().trim();
        if (!newSpecialization.isEmpty()) existingDoctor.setSpecialization(newSpecialization);

        System.out.print("Enter new availability (leave blank to keep current): ");
        String availStr = scanner.nextLine().trim();
        if (!availStr.isEmpty()) existingDoctor.setAvailability(Integer.parseInt(availStr));

        doctorHash.updateDoctor(existingDoctor);
        System.out.println("Doctor updated successfully.");
    }

    private static void deleteDoctor() throws Exception {
        System.out.print("Enter code of the doctor to delete: ");
        String deleteCode = Validate.checkInputString();
        if (doctorHash.searchDoctor(deleteCode).isEmpty()) {
            throw new Exception("Doctor code does not exist.");
        }
        doctorHash.deleteDoctor(deleteCode);
        System.out.println("Doctor deleted successfully.");
    }

   private static void searchDoctor() throws Exception {
    System.out.print("Enter search string: ");
    String searchString = Validate.checkInputString();
    HashMap<String, Doctor> searchResults = doctorHash.searchDoctor(searchString);
    
    if (searchResults.isEmpty()) {
        System.out.println("No doctors found.");
    } else {
        // In tiêu đề cho các cột
        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");

        // In các giá trị bác sĩ theo định dạng
        for (Doctor doctor : searchResults.values()) {
            System.out.printf("%-10s%-15s%-25s%-20d\n", 
                doctor.getCode(),
                doctor.getName(),
                doctor.getSpecialization(),
                doctor.getAvailability()
            );
        }
    }
}
}
