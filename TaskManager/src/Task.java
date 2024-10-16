
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author anhvu
 */
public class Task {

    private int id;
    private TaskType taskType;
    private String requirementName;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public String getRequirementName() throws Exception {
        if (requirementName.isEmpty()) {
            throw new Exception("RequirementName cannot be null");
        }
        return requirementName;
    }

    public void setRequirementName(String requirementName) throws Exception {
        if (requirementName.isEmpty()) {
            throw new Exception("RequirementName cannot be null");
        }
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) throws Exception {
        if (date == null) {
            throw new Exception("Date cannot be null or empty");
        }

        // Define date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); // Không cho phép định dạng không chính xác

        // Chuyển đổi đối tượng Date thành chuỗi
        String dateString = dateFormat.format(date);

        // Kiểm tra định dạng
        try {
            dateFormat.parse(dateString); // Nếu không đúng định dạng, sẽ ném ra ParseException
        } catch (ParseException e) {
            throw new Exception("Date is not in the correct format: " + e.getMessage());
        }

        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) throws Exception {
        if (planFrom < 8 || planFrom > 17.5) {
            throw new Exception("Plan From must be greater than 8 and less than 17");
        }
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) throws Exception {
        if (planTo < 8 || planTo > 17.5) {
            throw new Exception("Plan From must be greater than 8 and less than 17");
        }
        if (planTo < planFrom) {
            throw new Exception("Plan To must be greater than Plan From");
        }
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) throws Exception {
        if (assignee.isEmpty()) {
            throw new Exception("assignee cannot be null");
        }
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) throws Exception {
        if (reviewer.isEmpty()) {
            throw new Exception("reviewer cannot be null");
        }
        this.reviewer = reviewer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTaskType(TaskType taskType) throws Exception {
        if (requirementName.isEmpty()) {
            throw new Exception("taskType cannot be null");
        }
        this.taskType = taskType;
    }

    public Task(int id, Task task) {
        this.id = id;
    }

    public Task(int id, TaskType taskType, String requirementName, Date date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.taskType = taskType;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public TaskType getTaskType() {
        return taskType;
    }
    Validate validate = new Validate();
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        double totalDuration = planTo - planFrom;

        return String.format("%-10d %-20s %-20s %-20s %-20f %-20s %-20s",
                id,
                requirementName,
                taskType.getName(), // Assuming taskType has a getName() method
                dateFormat.format(date), // Use dateFormat to format the date
                totalDuration,
                assignee,
                reviewer);
    }

    private static int lastTaskId = 0;
    TaskType tt = new TaskType();

    public Task inputTask(Task task) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter Requirement Name: ");
                String requirementName = scanner.nextLine();
                task.setRequirementName(requirementName);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {

            try {
                System.out.print("Enter TaskTypeID (1-4): ");
                int taskTypeID = validate.checkInputLimit(1, 4);
                
                TaskType taskType = tt.getTaskTypeById(taskTypeID);
                task.setId(taskTypeID);
                task.setTaskType(taskType);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter Date (dd-MM-yyyy): ");
                String dateStr = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date date = dateFormat.parse(dateStr);
                task.setDate(date);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter Plan From (8.0 to 17.5): ");
                double planFrom = Double.parseDouble(scanner.nextLine());
                task.setPlanFrom(planFrom);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter Plan To (greater than Plan From): ");
                double planTo = Double.parseDouble(scanner.nextLine());
                task.setPlanTo(planTo);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter Assignee: ");
                String assignee = scanner.nextLine();
                task.setAssignee(assignee);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter Reviewer: ");
                String reviewer = scanner.nextLine();
                task.setReviewer(reviewer);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new Task(lastTaskId, task);
    }

}
