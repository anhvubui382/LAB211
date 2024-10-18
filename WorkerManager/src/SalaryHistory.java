import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalaryHistory extends Worker implements Comparable<SalaryHistory> {
   
    private String date;
    private String status;
 
    // Default constructor
    public SalaryHistory() {
     
    }

    // Constructor accepting ListWorker to access workers
    public SalaryHistory(ListWorker workerList) {
     
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

    SalaryHistory(Worker worker, String formattedDate, String addStatus) {
    super(worker.getId(), worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation());
    this.date = formattedDate;
    this.status = addStatus;
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


}
