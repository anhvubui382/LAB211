
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Manager {
    private ArrayList<Worker> lw;
    private ArrayList<History> lh;
    private Validate validate;  // Thêm validate thành biến đối tượng để tái sử dụng

    public Manager(ArrayList<Worker> lw, ArrayList<History> lh) {
        this.lw = lw;
        this.lh = lh;
        this.validate = new Validate();  // Khởi tạo đối tượng Validate
    }

    // Hiển thị menu
    public int menu() {
        System.out.println("1. Add worker.");
        System.out.println("2. Increase salary for worker.");
        System.out.println("3. Decrease for worker.");
        System.out.println("4. Show adjusted salary worker information.");
        System.out.println("5. Exit.");
        System.out.print("Enter your choice: ");
        return validate.checkInputIntLimit(1, 5);
    }

    // Thêm worker mới
    public void addWorker() {
        System.out.print("Enter code: ");
        String id = validate.checkInputString();
        if (validate.checkIdExist(lw, id)) {
            System.err.println("Code(id) must not be duplicated.");
            return;
        }
        
        System.out.print("Enter name: ");
        String name = validate.checkInputString();
        System.out.print("Enter age: ");
        int age = validate.checkInputIntLimit(18, 50);
        System.out.print("Enter salary: ");
        int salary = validate.checkInputSalary();
        System.out.print("Enter work location: ");
        String workLocation = validate.checkInputString();

        lw.add(new Worker(id, name, age, salary, workLocation));
        System.err.println("Add success.");
    }

    // Thay đổi lương (tăng hoặc giảm)
    public void changeSalary(int status) {
        if (lw.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter code: ");
        String id = validate.checkInputString();
        Worker worker = getWorkerByCode(id);
        if (worker == null) {
            System.err.println("Worker not found.");
            return;
        }

        int salaryCurrent = worker.getSalary();
        int salaryUpdate;

        if (status == 1) {
            System.out.print("Enter new salary (must be higher than current salary): ");
            salaryUpdate = validate.checkInputSalaryHigher(salaryCurrent);
            lh.add(new History("UP", getCurrentDate(), worker.getId(),
                    worker.getName(), worker.getAge(), salaryUpdate,
                    worker.getWorkLocation()));
        } else {
            System.out.print("Enter new salary (must be lower than current salary): ");
            salaryUpdate = validate.checkInputSalaryLower(salaryCurrent);
            lh.add(new History("DOWN", getCurrentDate(), worker.getId(),
                    worker.getName(), worker.getAge(), salaryUpdate,
                    worker.getWorkLocation()));
        }
        worker.setSalary(salaryUpdate);
        System.err.println("Salary updated successfully.");
    }

    // In danh sách lịch sử thay đổi lương
    public void printListHistory() {
        if (lh.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(lh);
        for (History history : lh) {
            printHistory(history);
        }
    }

    // Tìm worker theo code
    private Worker getWorkerByCode(String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    // Lấy ngày hiện tại
    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    // In lịch sử lương của worker
    private void printHistory(History history) {
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", history.getId(),
                history.getName(), history.getAge(), history.getSalary(),
                history.getStatus(), history.getDate());
    }
}
