public class Worker {
    private String id;
    private String name;
    private int age;
    private int salary;
    private String workLocation;

    public enum SalaryStatus {
        INCREASE, DECREASE
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if (id == null || id.trim().isEmpty()) {
            throw new Exception("ID cannot be null or empty.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age < 18 || age > 50) {
            throw new Exception("Age must be between 18 and 50.");
        }
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) throws Exception {
        if (salary <= 0) {
            throw new Exception("Salary must be greater than 0.");
        }
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15d %10d %s", id, name, age, salary, workLocation);
    }
}
