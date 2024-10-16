import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalaryHistory extends Worker implements Comparable<SalaryHistory> {
    private ArrayList<SalaryHistory> salaryHistories;
    private ListWorker workerList; // Reference to ListWorker
    
    private String date;
    private String status;
    Worker worker = new Worker();
    
    // Default constructor
    public SalaryHistory() {
        this.salaryHistories = new ArrayList<>();
    }

    // Constructor accepting ListWorker to access workers
    public SalaryHistory(ListWorker workerList) {
        this.workerList = workerList;
        this.salaryHistories = new ArrayList<>();
    }

    // Constructor for SalaryHistory details
    public SalaryHistory(String date, String status, String id, String name, int age, Double salary, String workLocation) {
        super(id, name, age, salary, workLocation);
        this.date = date;
        this.status = status;
    }

    public SalaryHistory(String date, String status) {
        this.date = date;
        this.status = status;
    }

    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    // Override the toString method for displaying information
    @Override
    public String toString() {
        return String.format("%-15s %-15s %10d %15.2f %10s %s",
                             this.getId(),
                             this.getName(),
                             this.getAge(),
                             this.getSalary(),
                             this.getStatus(),
                             this.getDate());
    }

    // Implement compareTo method (currently not supported)
    @Override
    public int compareTo(SalaryHistory o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Change salary and log history
    public boolean changeSalary(String status, String id, double amount) throws Exception {
        // Use workerList to find the worker by ID
        Worker worker = workerList.findWorkerById(id);
        if (worker == null) {
            throw new Exception("Worker not found.");
        }

        if (amount <= 0) {
            throw new Exception("Amount must be greater than 0.");
        }

        Double currentSalary = worker.getSalary();
        Double newSalary;
        String addStatus;

        if (status.equals("INCREASE")) {
            newSalary = currentSalary + amount;
            addStatus = "UP";
        } else if (status.equals("DECREASE")) {
            newSalary = currentSalary - amount;
            addStatus = "DOWN";
        } else {
            throw new Exception("Invalid status.");
        }

        if (newSalary < 0) {
            throw new Exception("Salary cannot be negative.");
        }

        worker.setSalary(newSalary);

        // Format the current date as a string in "dd/MM/yyyy" format
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(new Date());

        // Log salary change with formatted date as a String
        SalaryHistory history = new SalaryHistory(formattedDate, addStatus, worker.getId(), worker.getName(), worker.getAge(), newSalary, worker.getWorkLocation());
        salaryHistories.add(history);

        System.out.printf("Worker's salary updated successfully. New Salary: %f%n", newSalary);
        return true;
    }

    // Get salary history information
    public List<SalaryHistory> getInformationSalary() {
        return salaryHistories;
    }
}
