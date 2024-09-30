
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DoctorHash doctorHash = new DoctorHash();

    public static void main(String[] args) {
        DoctorHash doctorHash = new DoctorHash();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (option) {
                    case 1:
                        System.out.print("Enter code: ");
                        String code = Validate.checkInputString();
                        System.out.print("Enter name: ");
                        String name = Validate.checkInputString();
                        System.out.print("Enter specialization: ");
                        String specialization = Validate.checkInputString();
                        System.out.print("Enter availability: ");
                        int availability = Validate.checkInputInt();

                        Doctor doctor = new Doctor(code, name, specialization, availability);
                        doctorHash.addDoctor(doctor);
                        System.out.println("Doctor added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter code of the doctor to update: ");
                        String updateCode = Validate.checkInputString();
                        Doctor existingDoctor = doctorHash.searchDoctor(updateCode).get(updateCode);
                        if (existingDoctor != null) {
                            System.out.print("Enter new name (leave blank to keep current): ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter new specialization (leave blank to keep current): ");
                            String newSpecialization = scanner.nextLine();
                            System.out.print("Enter new availability (leave blank to keep current): ");
                            String availStr = scanner.nextLine();

                            if (!newName.isEmpty()) {
                                existingDoctor.setName(newName);
                            }
                            if (!newSpecialization.isEmpty()) {
                                existingDoctor.setSpecialization(newSpecialization);
                            }
                            if (!availStr.isEmpty()) {
                                existingDoctor.setAvailability(Integer.parseInt(availStr));
                            }

                            doctorHash.updateDoctor(existingDoctor);
                            System.out.println("Doctor updated successfully.");
                        } else {
                            System.out.println("Doctor code does not exist.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter code of the doctor to delete: ");
                        String deleteCode = Validate.checkInputString();
                        doctorHash.deleteDoctor(deleteCode);
                        System.out.println("Doctor deleted successfully.");
                        break;

                    case 4:
                        System.out.print("Enter search string: ");
                        String searchString = Validate.checkInputString();
                        HashMap<String, Doctor> searchResults = doctorHash.searchDoctor(searchString);
                        if (!searchResults.isEmpty()) {
                            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
                            searchResults.values().forEach(System.out::println);
                        } else {
                            System.out.println("No doctors found.");
                        }
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
}
