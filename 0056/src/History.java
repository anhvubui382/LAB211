

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class History extends Worker implements Comparable<History> {

    private String status;
    private String date;  // Should be validated in the format 'dd/MM/yyyy'
    
    public History() {
    }

    public History(String status, String date, String id, String name, int age,
                   int salary, String workLocation) throws Exception {
        super(id, name, age, salary, workLocation);
        setStatus(status);
        setDate(date);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) throws Exception {
        if (status == null || status.trim().isEmpty()) {
            throw new Exception("Status cannot be null or empty.");
        }
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) throws Exception {
        if (!isValidDate(date)) {
            throw new Exception("Invalid date format. Use dd/MM/yyyy.");
        }
        this.date = date;
    }

    // Utility method for date validation
    private boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);  // Strict parsing to catch invalid dates
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public int compareTo(History t) {
        return this.getId().compareTo(t.getId());
    }
     public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
   //allow user print history
    public static void printListHistory(ArrayList<History> lh) {
        if (lh.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(lh);
        //print history from first to last list
        for (History history : lh) {
            printHistory(history);
        }
    }

    //print history
    public static void printHistory(History history) {
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }
}
