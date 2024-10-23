
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
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();

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
                    while (true) {
                        try {
                            Task newTask = new Task();
                            System.out.println("-----Add Task-----");
                            newTask.inputTask();

                            taskList.addTask(newTask);

                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

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
