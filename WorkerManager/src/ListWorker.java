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

    public List<Worker> getWorkerList() {
      
        return new ArrayList<>(workers); // Return a copy of the list to avoid external modification
    }
}
