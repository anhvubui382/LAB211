
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TaskList {
    private static List<Task> taskList = new ArrayList<>();
    private static List<TaskType> taskTypes = List.of(
            new TaskType(1, "Code"),
            new TaskType(2, "Test"),
            new TaskType(3, "Design"),
            new TaskType(4, "Review")
    );
    private static int lastTaskId = 0;

   

    
    // Function to add task
    public static void addTask(Task task) throws Exception {
        System.out.println(task);
        
        Task newTask2 = new Task(lastTaskId, task.getTaskType(), task.getRequirementName(), task.getDate(), task.getPlanFrom(), task.getPlanTo(), task.getAssignee(), task.getReviewer());
        // Thêm task vào danh sách
        taskList.add(newTask2);
        
        System.out.println("Task added successfully.");
    }

    // Function to delete task
    public static void deleteTask(int taskId) throws Exception {
      
        
        Task taskToDelete = null;
        for (Task task : taskList) {
            if (task.getId() == taskId) {
                taskToDelete = task;
                break;
            }
        }

        if (taskToDelete == null) {
            throw new Exception("Task ID does not exist.");
        }

        taskList.remove(taskToDelete);
        System.out.println("Task deleted successfully.");
    }

    // Function to show tasks
    public static void showTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s%n", "ID", "Name","Task Type", "Date",  "Time", "Assignee", "Reviewer");
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
    }

    // Helper to find TaskType by ID
    public static TaskType getTaskTypeById(int id) {
        for (TaskType taskType : taskTypes) {
            if (taskType.getId() == id) {
                return taskType;
            }
        }
        return null;
    }
}