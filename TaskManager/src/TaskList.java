
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TaskList {

    private static ArrayList<Task> taskList = new ArrayList<>();
    private static List<TaskType> taskTypes = List.of(
            new TaskType(1, "Code"),
            new TaskType(2, "Test"),
            new TaskType(3, "Design"),
            new TaskType(4, "Review")
    );

    public TaskList() {
    }

    public boolean addTask(Task task) throws Exception {
        for (Task existingTask : taskList) {
            if (existingTask.getId() == task.getId()) {
                throw new Exception("Task with the same ID already exists.");
            }
        }
        
        taskList.add(task);
        System.out.println("Task added successfully.");
        return true;
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
            System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s %-20s%n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
    }

    public static TaskType getTaskTypeById(int id) {
        for (TaskType taskType : taskTypes) {
            if (taskType.getId() == id) {
                return taskType;
            }
        }
        return null;
    }

}
