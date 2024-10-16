
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author anhvu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static List<Task> taskList = new ArrayList<>();
 
    private static List<TaskType> taskTypes = Arrays.asList(
            new TaskType(1, "Code"),
            new TaskType(2, "Test"),
            new TaskType(3, "Design"),
            new TaskType(4, "Review")
    );
    private static int lastTaskId = 0;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();
        Task task = new Task();
        while (true) {

            showMenu();
            int option;
            try {
                option = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                continue;
            }
            // Consume newline

            switch (option) {
                case 1:
                    System.out.println("-----Add worker-----");
                    task.inputTask(task);
                    taskList.addTask(task);  
                   
                    break;
                case 2:
                    
                        try {
                    System.out.print("Enter Task ID to delete: ");
                    int taskId = Integer.parseInt(scanner.nextLine());
                    taskList.deleteTask(taskId);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
                case 3:
                    taskList.showTasks();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }
    }

    private static void showMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Show Task");
        System.out.println("4. Exit");
        System.out.print("Select an option (1-4): ");
    }

}
