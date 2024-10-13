
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for input
        DoctorList doctorList = new DoctorList(); // Create a DoctorList instance
        Doctor doctor = new Doctor();
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Display Doctors");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");

            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1: // Add Doctor
                    while (true) {
                        try {
                            while (true) {
                                try {
                                    System.out.print("Enter doctor code: ");
                                    String code = scanner.nextLine().trim();
                                    doctor.setCode(code);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            while (true) {
                                try {
                                    System.out.print("Enter doctor name: ");
                                    String name = scanner.nextLine().trim();
                                    doctor.setName(name);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            while (true) {
                                try {
                                    System.out.print("Enter doctor specialization: ");
                                    String specialization = scanner.nextLine().trim();
                                    doctor.setSpecialization(specialization);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            while (true) {
                                try {
                                    System.out.print("Enter doctor availability: ");
                                    int availability = Integer.parseInt(scanner.nextLine().trim());
                                    doctor.setAvailability(availability);
                                    break;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            // Add the doctor to the list
                            doctorList.addDoctor(doctor);
                            System.out.println("Doctor added successfully.");

                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    }

                case 2: // Update Doctor
                    try {
                    System.out.print("Enter doctor code to update: ");
                    String code = scanner.nextLine().trim();
                    Doctor existingDoctor = doctorList.findDoctorByCode(code);
                    if (existingDoctor != null) {
                        System.out.print("Enter new name (leave blank to keep current): ");
                        String name = scanner.nextLine().trim();
                        if (!name.isEmpty()) {
                            existingDoctor.setName(name);
                        }

                        System.out.print("Enter new specialization (leave blank to keep current): ");
                        String specialization = scanner.nextLine().trim();
                        if (!specialization.isEmpty()) {
                            existingDoctor.setSpecialization(specialization);
                        }

                        System.out.print("Enter new availability (leave blank to keep current): ");
                        String availabilityInput = scanner.nextLine().trim();
                        if (!availabilityInput.isEmpty()) {
                            int availability = Integer.parseInt(availabilityInput);
                            existingDoctor.setAvailability(availability);
                        }

                        System.out.println("Doctor updated successfully.");
                    } else {
                        System.out.println("Doctor not found.");
                    }

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

                case 3: // Delete Doctor
                    try {
                    System.out.print("Enter doctor code to delete: ");
                    String code = scanner.nextLine().trim();
                    boolean deleted = doctorList.deleteDoctor(code);
                    if (deleted) {
                        System.out.println("Doctor deleted successfully.");
                    } else {
                        System.out.println("Doctor not found.");
                    }

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

                case 4: // Display Doctors
                    System.out.println("\nList of Doctors:");
                    doctorList.displayDoctors();
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
