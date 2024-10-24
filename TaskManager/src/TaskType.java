
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author anhvu
 */
public class TaskType {

    private int id;
    private String name;

    public static List<TaskType> getTaskTypes() {
        return taskTypes;
    }

    public static void setTaskTypes(List<TaskType> taskTypes) {
        TaskType.taskTypes = taskTypes;
    }
    
    private static List<TaskType> taskTypes = List.of(
            new TaskType(1, "Code"),
            new TaskType(2, "Test"),
            new TaskType(3, "Design"),
            new TaskType(4, "Review")
    );

    public TaskType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }

    

    public TaskType() {
    }
}
