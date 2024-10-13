import java.util.ArrayList;
import java.util.List;

public class SalaryHistory extends Worker implements Comparable<Worker> {

    public enum SalaryStatus {
        INCREASE, DECREASE
    }

    private String workerId;
    private double oldSalary;
    private double newSalary;
    private String action; // "Increase" or "Decrease"
    
    // Danh sách lưu trữ lịch sử lương
    private List<SalaryHistory> salaryHistoryList;
    private ListWorker listW = new ListWorker();
    public SalaryHistory() {
        this.salaryHistoryList = new ArrayList<>();
    }

    public SalaryHistory(ListWorker listWorker) {
        this();
       
    }

    public SalaryHistory(String id, String name, int age, int salary, String workLocation) throws Exception {
        super(id, name, age, salary, workLocation);
        this.salaryHistoryList = new ArrayList<>();
    }

    public SalaryHistory(String workerId, double oldSalary, double newSalary, String action) {
        this();
        this.workerId = workerId;
        this.oldSalary = oldSalary;
        this.newSalary = newSalary;
        this.action = action;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public double getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(double oldSalary) {
        this.oldSalary = oldSalary;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(double newSalary) {
        this.newSalary = newSalary;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Worker ID: %s | Old Salary: %.2f | New Salary: %.2f | Action: %s",
                workerId, oldSalary, newSalary, action);
    }

    @Override
    public int compareTo(Worker t) {
        return this.getId().compareTo(t.getId());
    }
    ArrayList<ListWorker> listWorker;
    
    public boolean changeSalary(int amount, String code, SalaryStatus status) {
        try {
            Worker worker = listW.findWorkerByCode(code);
            if (worker == null) {
                System.out.println("Worker not found with code: " + code);
                return false;
            }

            // Lưu lương cũ trước khi thay đổi
            double currentSalary = worker.getSalary();
            double newSalary = currentSalary; // Biến để lưu lương mới
            String action = ""; // Biến để lưu hành động

            // Điều chỉnh lương dựa trên trạng thái
            if (status == SalaryStatus.INCREASE) {
                newSalary = currentSalary + amount;
                action = "Increase";
            } else if (status == SalaryStatus.DECREASE) {
                if (currentSalary < amount) {
                    System.out.println("Cannot decrease salary below zero.");
                    return false;
                }
                newSalary = currentSalary - amount;
                action = "Decrease";
            }

            // Cập nhật lương mới
            worker.setSalary((int) newSalary);

            // Lưu bản ghi lịch sử lương
            SalaryHistory record = new SalaryHistory(worker.getId(), currentSalary, newSalary, action);
            salaryHistoryList.add(record);
            System.out.println(worker);
            System.out.println("Salary adjusted successfully for worker: " + code);
            return true;

        } catch (Exception e) {
            System.out.println("Error adjusting salary: " + e.getMessage());
            return false;
        }
    }

    public List<SalaryHistory> getInformationSalary() {
        System.out.println(salaryHistoryList);
        return salaryHistoryList; // Trả về danh sách lịch sử lương
    }
}
