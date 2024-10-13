import java.util.Date;

public class SalaryHistory {
    private String workerId;
    private Worker.SalaryStatus status;
    private double amount;
    private Date date;

    public SalaryHistory(String workerId, Worker.SalaryStatus status, double amount, Date date) {
        this.workerId = workerId;
        this.status = status;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %10.2f %s", workerId, status, amount, date);
    }
}
