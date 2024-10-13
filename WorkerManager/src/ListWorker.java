import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListWorker {
    private ArrayList<Worker> workers;
    private ArrayList<SalaryHistory> salaryHistories;

    public ListWorker() {
        this.workers = new ArrayList<>();
        this.salaryHistories = new ArrayList<>();
    }

    public boolean addWorker(Worker worker) {
        if (findWorkerById(worker.getId()) != null) {
            System.out.println("Error adding worker: Worker ID already exists.");
            return false;
        }
        workers.add(worker);
        return true;
    }

    public Worker findWorkerById(String id) {
        for (Worker worker : workers) {
            if (worker.getId().equals(id)) {
                return worker;
            }
        }
        return null;
    }

    public boolean changeSalary(String status, String id, double amount) throws Exception {
        Worker worker = findWorkerById(id);
        if (worker == null) {
            throw new Exception("Worker not found.");
        }

        if (amount <= 0) {
            throw new Exception("Amount must be greater than 0.");
        }

        Double currentSalary = worker.getSalary();
        Double newSalary; 
        String addStatus;
        if(status == "INCREASE"){
            newSalary = currentSalary + amount;
            addStatus = "UP";
        } else {
            newSalary = currentSalary - amount;
            addStatus = "DOWN";
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

    public List<SalaryHistory> getInformationSalary() {
       
        return salaryHistories;
    }
}
