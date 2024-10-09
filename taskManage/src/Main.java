
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static final String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";
    private static final Task task = new Task();
    private static final ArrayList<Task> lt = new ArrayList<>();
    private static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static String checkInputDate() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            } catch (ParseException ex) {
                System.err.println("Re-input");
            }
        }
    }

    private static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Not empty.");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input: ");
            }
        }
    }
private static Double checkInputDouble() {
        while (true) {
            try {
                Double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input: ");
            }
        }
    }

    private static String checkInputTaskTypeId() {
        while (true) {
            int n = checkIntLimit(1, 4);
            String result = null;
            switch (n) {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "manager";
                    break;
                case 4:
                    result = "learn";
            }
            return result;
        }
    }

    private static Double checkInputPlan() {
        while (true) {
            Double result = checkInputDouble();
            if (result >= 8.0 && result <= 17.5) {
                return result;
            } else {
                System.err.println("Re-input.");
            }
        }
    }

    private static void addTask(int id) throws Exception {
        System.out.print("Enter Requirement Name: ");
        
        task.setRequirementName(checkInputString());
        System.out.print("Enter Task Type: ");
        task.setTaskTypeId(checkInputTaskTypeId());
       
        System.out.print("Enter Date: ");
        task.setDate(checkInputDate());
       
        System.out.print("Enter From: ");
        task.setPlanFrom(checkInputPlan());
       
        System.out.print("Enter To: ");
        task.setPlanTo(checkInputPlan());
        
        System.out.print("Enter Assignee: ");
        task.setAssign(checkInputString());
       
        System.out.print("Enter Reviewer: ");
        task.setReviewer(checkInputString());
       
        lt.add(task);
        System.out.println("Add Task Success.");
    }

    private static void deleteTask(int id) throws Exception {
        if (lt.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        int findId = findTaskExist();
        if (findId != -1) {
            lt.remove(findId);
            for (int i = findId; i < lt.size(); i++) {
                lt.get(i).setId(lt.get(i).getId() - 1);
            }
            System.err.println("Delete success.");
        }
    }

    private static int findTaskExist() {
        System.out.print("Enter id: ");
        int id = checkInputInt();
        for (int i = 0; i < lt.size(); i++) {
            if (lt.get(i).getId() == id) {
                return i;
            }
        }
        System.err.println("Not found.");
        return -1;
    }

    private static void print(ArrayList<Task> lt) {
        if (lt.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < lt.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    lt.get(i).getId(),
                    lt.get(i).getRequirementName(),
                    lt.get(i).getTaskTypeId(),
                    lt.get(i).getDate(),
                    lt.get(i).getPlanTo() - lt.get(i).getPlanFrom(),
                    lt.get(i).getAssign(),
                    lt.get(i).getReviewer()
            );

        }
    }

    private static void display() throws Exception {
        ArrayList<Task> lt = new ArrayList<>();
        int choice;
        int id = 1;
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    addTask(id);
                    id++;
                    break;
                case 2:
                    deleteTask(id);
                    id--;
                    break;
                case 3:
                    print(lt);
                    break;
                case 4:
                    return;

            }
        }
    }

    public static void main(String[] args) throws IOException, Exception {
        display();
    }
}