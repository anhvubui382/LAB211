import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Task {

    private int id;
    private String taskTypeId;
    private String requirementName;
    private String date;
    private double planFrom;
    private double planTo;
    private String assign;
    private String reviewer;

    public Task() {
    }

    public Task(int id, String taskTypeId, String requirementName, String date, double planFrom, double planTo, String assign, String reviewer) throws Exception {
        setId(id);
        setTaskTypeId(taskTypeId);
        setRequirementName(requirementName);
        setDate(date);
        setPlanFrom(planFrom);
        setPlanTo(planTo);
        setAssign(assign);
        setReviewer(reviewer);
    }

    // Getters and Setters with Exception Handling

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Task ID must be positive.");
        }
        this.id = id;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(String taskTypeId) throws Exception {
        if (taskTypeId == null || taskTypeId.trim().isEmpty()) {
            throw new Exception("Task Type ID cannot be null or empty.");
        }
        if (!taskTypeId.matches("[1-4]")) {
            throw new Exception("Invalid Task Type ID. It must be between 1 and 4.");
        }
        this.taskTypeId = taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) throws Exception {
        if (requirementName == null || requirementName.trim().isEmpty()) {
            throw new Exception("Requirement Name cannot be null or empty.");
        }
        this.requirementName = requirementName;
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

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) throws Exception {
        if (!isValidTime(planFrom)) {
            throw new Exception("Plan From must be between 8.0 and 17.5 in 0.5 increments.");
        }
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) throws Exception {
        if (!isValidTime(planTo)) {
            throw new Exception("Plan To must be between 8.0 and 17.5 in 0.5 increments.");
        }
        if (planTo <= planFrom) {
            throw new Exception("Plan To must be greater than Plan From.");
        }
        this.planTo = planTo;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) throws Exception {
        if (assign == null || assign.trim().isEmpty()) {
            throw new Exception("Assign cannot be null or empty.");
        }
        this.assign = assign;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) throws Exception {
        if (reviewer == null || reviewer.trim().isEmpty()) {
            throw new Exception("Reviewer cannot be null or empty.");
        }
        this.reviewer = reviewer;
    }

    // Utility methods for date and time validation

    private boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isValidTime(double time) {
        return time >= 8.0 && time <= 17.5 && (time * 10) % 5 == 0; // Ensures 0.5 increments
    }
}
