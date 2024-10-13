
import java.util.ArrayList;

public class Worker {

    enum SalaryStatus {
        INCREASE, DECREASE
    }

    private String id;
    private String name;
    private int age;
    private int salary;
    private String workLocation;
    private ArrayList<Worker> listWorker = new ArrayList<>();

    public Worker() {
    }

    public Worker(String id, String name, int age, int salary, String workLocation) throws Exception {
        setId(id);
        setAge(age);
        setName(name);
        setSalary(salary);
        setWorkLocation(workLocation);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if (id.isEmpty()) {
            throw new Exception("Code cannot be null");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.isEmpty()) {
            throw new Exception("Name cannot be null");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age < 18 || age > 50) { // Assuming age must be between 18 and 50
            throw new Exception("Age must be between 18 and 50");
        }
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) throws Exception {
        if (salary <= 0) {
            throw new Exception("Salary must be greater than 0");
        }
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) throws Exception {
        if (workLocation.isEmpty()) {
            throw new Exception("Work location cannot be null");
        }
        this.workLocation = workLocation;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Age: %d | Salary: %d | Work Location: %s",
                getId(), getName(), getAge(), getSalary(), getWorkLocation());
    }

   
}
