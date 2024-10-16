
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        ListWorker workerList = new ListWorker();
        SalaryHistory salaryHistory = new SalaryHistory(workerList);
        Scanner scanner = new Scanner(System.in);

        while (true) {

            // Display menu options
            System.out.println("\nMenu:");
            System.out.println("1. Add Worker");
            System.out.println("2. Increase Salary");
            System.out.println("3. Decrease Salary");
            System.out.println("4. Show Adjusted Salary Workers");
            System.out.println("5. Quit");
            System.out.print("Select an option (1-5): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1: // Add Worker
                    try {
                    Worker newWorker = new Worker();
                   
                    if (!workerList.checkValidWorker(newWorker.inputWorker())) {
                        System.out.println("Add Doctor Successfull");
                        workerList.addWorker(newWorker);
                    } else {
                        System.out.println("Failed to add doctor.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

                case 2: // Increase Salary
                    try {
                    System.out.print("Enter worker id: ");
                    String idToIncrease = scanner.nextLine().trim();
                    System.out.print("Enter amount to increase salary: ");
                    double increaseAmount = Double.parseDouble(scanner.nextLine().trim());
                    salaryHistory.changeSalary("INCREASE", idToIncrease, increaseAmount);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

                case 3: // Decrease Salary
                    try {
                    System.out.print("Enter worker id: ");
                    String idToDecrease = scanner.nextLine().trim();
                    System.out.print("Enter amount to decrease salary: ");
                    double decreaseAmount = Double.parseDouble(scanner.nextLine().trim());
                    salaryHistory.changeSalary("DECREASE", idToDecrease, decreaseAmount);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

                case 4: // Show Adjusted Salary Workers
                    System.out.printf("%-15s %-15s %10s %15s %10s %s%n", "Code", "Name", "Age", "Salary", "Status", "Date");
                    List<SalaryHistory> workerList2 = salaryHistory.getInformationSalary(); // Giả sử đây là danh sách bạn có

                    // Sắp xếp danh sách theo id1
                    workerList2.sort(Comparator.comparing(SalaryHistory::getId));
                    for (SalaryHistory history : workerList2) {
                        System.out.println(history);

                    }
                    break;

                case 5: // Quit
                    System.out.println("Program terminated.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
