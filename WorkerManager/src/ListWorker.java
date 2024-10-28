
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

    public boolean checkValidWorker(Worker inputWorker) {
        System.out.println(inputWorker);
        for (Worker worker : workers) {
            if (worker.getId().equals(inputWorker.getId())) {
                return true;
            }
        }
        return false;
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
        System.out.println("change: " + status + ", " + id);
        Worker worker = findWorkerById(id);
        SalaryHistory history = new SalaryHistory();
        if (worker == null) {
            throw new Exception("Worker not found.");
        }

        if (amount <= 0) {
            throw new Exception("Amount must be greater than 0.");
        }

        // Cập nhật lương worker
        if (status.equals("INCREASE")) {
            worker.setSalary(worker.getSalary() + amount);
            history.setStatus("UP");

        } else if (status.equals("DECREASE")) {

            if (worker.getSalary() < 0) {
                throw new Exception("Salary cannot be negative.");
            }
            worker.setSalary(worker.getSalary() - amount);
            history.setStatus("DOWN");
        } else {
            throw new Exception("Invalid status.");
        }
        
        // Thêm lịch sử lương
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(new Date());
        System.out.println(history);
        salaryHistories.add(history);

        System.out.printf("Worker's salary updated successfully. New Salary: %f%n", worker.getSalary());
        return true;
    }
//    public boolean changeSalary(String status, String id, double amount) throws Exception {
//        // Use workerList to find the worker by ID
//        Worker worker = findWorkerById(id);
//        if (worker == null) {
//            throw new Exception("Worker not found.");
//        }
//
//        if (amount <= 0) {
//            throw new Exception("Amount must be greater than 0.");
//        }
//
//        Double currentSalary = worker.getSalary();
//        Double newSalary;
//        String addStatus;
//
//        if (status.equals("INCREASE")) {
//            worker.setSalary(worker.getSalary()+amount);
//            newSalary = currentSalary + amount;
//            addStatus = "UP";
//        } else if (status.equals("DECREASE")) {
//            newSalary = currentSalary - amount;
//            addStatus = "DOWN";
//        } else {
//            throw new Exception("Invalid status.");
//        }
//
//        if (newSalary < 0) {
//            throw new Exception("Salary cannot be negative.");
//        }
//
//        worker.setSalary(newSalary);
//
//        // Format the current date as a string in "dd/MM/yyyy" format
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String formattedDate = formatter.format(new Date());
//
//        // Log salary change with formatted date as a String
//        SalaryHistory history = new SalaryHistory(worker.getId(),formattedDate, addStatus);
//        salaryHistories.add(history);
//
//        System.out.printf("Worker's salary updated successfully. New Salary: %f%n", newSalary);
//        return true;
//    }

    // Get salary history information
    public List<SalaryHistory> getInformationSalary() {
        return salaryHistories;
    }

    public List<Worker> getWorkerList() {

        return new ArrayList<>(workers); // Return a copy of the list to avoid external modification
    }
}
