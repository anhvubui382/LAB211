
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author anhvu
 */
public class ListWorker {

  public ArrayList<Worker> listWorker;
  public ArrayList<SalaryHistory> salaryHistoryList = new ArrayList<>(); // Danh sách lưu lịch sử lương

    // A helper method to find a worker by their code (assumed)
  
    public ListWorker() {
    }

  
    public Worker findWorkerByCode(String code) {
        // Assume listWorker is a collection of workers
        System.out.println("code find:  " + code);
        System.out.println();
        for (Worker worker : listWorker) {
            System.out.println(worker.getId());
            if (worker.getId().equals(code)) {
                System.out.println(worker);
                return worker;
            }
        }
        return null;
    }

    // Lấy lịch sử thay đổi lương của một worker cụ thể
    public ArrayList<SalaryHistory> getSalaryHistoryByWorkerId(String workerId) {
        ArrayList<SalaryHistory> workerHistory = new ArrayList<>();
        for (SalaryHistory history : salaryHistoryList) {
            if (history.getWorkerId().equals(workerId)) {
                workerHistory.add(history);
            }
        }
        return workerHistory;
    }
     public boolean addWorker(Worker worker) {
        try {
            listWorker.add(worker);
            System.out.println("Add success");
//            System.out.println(listWorker);

            return true;
        } catch (Exception e) {

            return false;
        }

    }
    public ArrayList<Worker> getWorkers() {
        return listWorker; // Trả về danh sách công nhân
    }

    @Override
    public String toString() {
        return "ListWorker{" + "listWorker=" + listWorker + ", salaryHistoryList=" + salaryHistoryList + '}';
    }
    
}
