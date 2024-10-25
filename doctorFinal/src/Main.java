
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoctorHash doctorHash = new DoctorHash();
        Doctor doctor = new Doctor();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (option) {
                    case 1:

                        doctor = doctor.inputDoctor();
                        Boolean result = doctorHash.addDoctor(doctor);
                        if (!result) {
                            System.out.println("Doctor code " + doctor.getCode() + " is duplicate.");
                        } else {
                            System.out.println("Doctor added successfully.");
                        }
                        break;

                    case 2:
                        System.out.print("Enter Code of Doctor to update: ");
                        String code = scanner.nextLine();
                        Doctor existingDoctor = doctorHash.searchDoctor(code).get(code);
                        if (existingDoctor == null) {
                            System.out.println("Doctor code does not exist.");
                        } else {
                            existingDoctor.updateDoctorDetails();
                            doctorHash.updateDoctor(existingDoctor);
                            System.out.println("Doctor updated successfully.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Code of Doctor to delete: ");
                        code = scanner.nextLine();
                        if (doctorHash.deleteDoctor(code)) {
                            System.out.println("Doctor deleted successfully.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter search term: ");
                        String searchTerm = scanner.nextLine();
                        Map<String, Doctor> results = doctorHash.searchDoctor(searchTerm);

                        for (Map.Entry<String, Doctor> entry : results.entrySet()) {
                            System.out.println(entry.getValue());
                        }
                        break;

                    case 5:
                        System.out.println("Exiting program...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
