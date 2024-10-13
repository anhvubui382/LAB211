
public class SalaryHistory extends Worker implements Comparable<SalaryHistory>{
    
   
   private String date;
   private String status;
   Worker worker = new Worker();

    public SalaryHistory() {
    }

    public SalaryHistory(String date, String status, String id, String name, int age, Double salary, String workLocation) {
        super(id, name, age, salary, workLocation);
        this.date = date;
        this.status = status;
    }

    public SalaryHistory(String date, String status) {
        this.date = date;
        this.status = status;
    }



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
    @Override
    public int compareTo(SalaryHistory o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
