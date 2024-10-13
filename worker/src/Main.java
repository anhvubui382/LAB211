
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Worker worker = new Worker();
        ListWorker listWorker = new ListWorker();
        SalaryHistory salaryHistory = new SalaryHistory();
  List<SalaryHistory> salaryHistoryList;
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        listWorker.addWorker(new Worker("fu1", "Bui Anh Vu", 22, 100, "Vietnam"));
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add Worker");
            System.out.println("2. Increase Salary");
            System.out.println("3. Decrease Salary");
            System.out.println("4. Show Salary History");
            System.out.println("5. Quit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    // Add Worker
                    while (true) {
                        try {
                            System.out.print("Enter Worker ID: ");
                            worker.setId(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());

                        }

                    }

                    System.out.print("Enter Worker Name: ");
                    worker.setName(scanner.nextLine());
                    System.out.print("Enter Worker Age: ");
                    worker.setAge(scanner.nextInt());

                    System.out.print("Enter Worker Salary: ");
                    worker.setSalary(scanner.nextInt());

                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Work Location: ");
                    worker.setWorkLocation(scanner.nextLine());

                    try {
                        listWorker.addWorker(worker);
                        System.out.println("Worker added successfully.");
                        
                        
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Increase Salary
                 
                    System.out.print("Enter Worker ID: ");
                    String increaseId = scanner.nextLine();
                    System.out.print("Enter Amount to Increase: ");
                    int increaseAmount = scanner.nextInt();
                    try {
                        salaryHistory.changeSalary(increaseAmount, increaseId, SalaryHistory.SalaryStatus.INCREASE);
                        System.out.println("Salary increased successfully.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Decrease Salary
                    System.out.print("Enter Worker ID: ");
                    String decreaseId = scanner.nextLine();
                    System.out.print("Enter Amount to Decrease: ");
                    int decreaseAmount = scanner.nextInt();
                    try {
                        salaryHistory.changeSalary(decreaseAmount, decreaseId, SalaryHistory.SalaryStatus.DECREASE);
                        System.out.println("Salary decreased successfully.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                   

                    salaryHistory.getInformationSalary();
        
       
                  
                    break;
                case 5:
                    // Quit
                    running = false;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
