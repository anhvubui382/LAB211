
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;

public class Worker {

    private String id;
    private String name;
    private int age;
    private int salary;
    private String workLocation;

    public Worker() {
    }

    public Worker(String id, String name, int age, int salary, String workLocation) throws Exception {
        setId(id);
        setName(name);
        setAge(age);
        setSalary(salary);
        setWorkLocation(workLocation);
    }

    // Getters and Setters with validation
    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if (id == null || id.trim().isEmpty()) {
            throw new Exception("Worker ID cannot be null or empty.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Worker name cannot be null or empty.");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age <= 0) {
            throw new Exception("Age must be positive.");
        }
        if (age < 18 || age > 65) { // Assuming reasonable working age limits
            throw new Exception("Worker age must be between 18 and 65.");
        }
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) throws Exception {
        if (salary < 0) {
            throw new Exception("Salary cannot be negative.");
        }
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) throws Exception {
        if (workLocation == null || workLocation.trim().isEmpty()) {
            throw new Exception("Work location cannot be null or empty.");
        }
        this.workLocation = workLocation;
    }
private final static Scanner in = new Scanner(System.in);
   public static void addWorker(ArrayList<Worker> lw) throws Exception {
    Worker newWorker = new Worker();
    
    // Input and validation for the worker ID
    while (true) {
        System.out.print("Enter code: ");
        try {
            newWorker.setId(Validate.checkInputString()); // Directly setting the ID using the setter
            if (Validate.checkIdExist(lw, newWorker.getId())) {
                System.err.println("Code (ID) must exist in the database. Please enter a valid code.");
            } else {
                break; // If the ID is valid, proceed
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Handle exceptions thrown by the setter
        }
    }
    
    // Input and validation for the worker's name
    while (true) {
        System.out.print("Enter name: ");
        try {
            newWorker.setName(Validate.checkInputString()); // Directly setting the name using the setter
            break; // Break the loop once a valid name is set
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Handle exceptions thrown by the setter
        }
    }

    // Input and validation for the worker's age
    while (true) {
        System.out.print("Enter age: ");
        try {
            newWorker.setAge(Validate.checkInputIntLimit(18, 50)); // Directly setting the age
            break; // Break the loop once a valid age is set
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Handle exceptions thrown by the setter
        }
    }

    // Input and validation for the worker's salary
    while (true) {
        System.out.print("Enter salary: ");
        try {
            newWorker.setSalary(Validate.checkInputSalary()); // Directly setting the salary
            break; // Break the loop once a valid salary is set
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Handle exceptions thrown by the setter
        }
    }

    // Input and validation for the work location
    while (true) {
        System.out.print("Enter work location: ");
        try {
            newWorker.setWorkLocation(Validate.checkInputString()); // Directly setting the work location
            break; // Break the loop once a valid work location is set
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Handle exceptions thrown by the setter
        }
    }

    // Check if the worker already exists to avoid duplication
    if (!Validate.checkWorkerExist(lw, newWorker.getId(), newWorker.getName(), newWorker.getAge(), newWorker.getSalary(), newWorker.getWorkLocation())) {
        System.err.println("Duplicate worker.");
    } else {
        lw.add(newWorker);
        System.err.println("Worker added successfully.");
    }
}


    //allow user increase salary for user
    public static void changeSalary(ArrayList<Worker> lw, ArrayList<History> lh, int status) throws Exception {
        if (lw.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter code: ");
        String id = Validate.checkInputString();
        
        Worker worker = getWorkerByCode(lw, id);
        if (worker == null) {
            System.err.println("Not exist worker.");
        } else {
            int salaryCurrent = worker.getSalary();
            int salaryUpdate;
            //check user want to update salary
            if (status == 1) {
                System.out.print("Enter salary: ");
                //loop until user input salary update > salary current
                while (true) {
                    salaryUpdate = Validate.checkInputSalary();
                    //check user input salary update > salary current
                    if (salaryUpdate <= salaryCurrent) {
                        System.err.println("Must be greater than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("UP", History.getCurrentDate(), worker.getId(), worker.getName(), worker.getAge(), salaryUpdate, worker.getWorkLocation()));
            } else {
                System.out.print("Enter salary: ");
                //loop until user input salary update < salary current
                while (true) {
                    salaryUpdate = Validate.checkInputSalary();
                    //check user input salary update < salary current
                    if (salaryUpdate >= salaryCurrent) {
                        System.err.println("Must be smaller than current salary.");
                        System.out.print("Enter again: ");
                    } else {
                        break;
                    }
                }
                lh.add(new History("UP", History.getCurrentDate(), worker.getId(),
                        worker.getName(), worker.getAge(), salaryUpdate,
                        worker.getWorkLocation()));
            }
            worker.setSalary(salaryUpdate);
            System.err.println("Update success");
        }
    }

    //get worker by code
    public static Worker getWorkerByCode(ArrayList<Worker> lw, String id) {
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    //get current date 
}
