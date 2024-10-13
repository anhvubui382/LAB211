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

    public boolean changeSalary(Worker.SalaryStatus status, String id, double amount) throws Exception {
        Worker worker = findWorkerById(id);
        if (worker == null) {
            throw new Exception("Worker not found.");
        }

        if (amount <= 0) {
            throw new Exception("Amount must be greater than 0.");
        }

        int currentSalary = worker.getSalary();
        int newSalary = (status == Worker.SalaryStatus.INCREASE) ? (currentSalary + (int) amount) : (currentSalary - (int) amount);

        if (newSalary < 0) {
            throw new Exception("Salary cannot be negative.");
        }

        worker.setSalary(newSalary);
        
        // Log salary change
        SalaryHistory history = new SalaryHistory(worker.getId(), status, amount, new Date());
        salaryHistories.add(history);
        System.out.printf("Worker's salary updated successfully. New Salary: %d%n", newSalary);
        return true;
    }

    public List<SalaryHistory> getInformationSalary() {
        return salaryHistories;
    }
}
