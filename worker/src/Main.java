
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<Worker> lw = new ArrayList<>();
        ArrayList<History> lh = new ArrayList<>();
        Manager manager = new Manager(lw, lh);  // Tạo đối tượng manager
        
        // loop until user want to exit
        while (true) {
            int choice = manager.menu();
            switch (choice) {
                case 1:
                    manager.addWorker();
                    break;
                case 2:
                    manager.changeSalary(1);  // 1 để tăng lương
                    break;
                case 3:
                    manager.changeSalary(2);  // 2 để giảm lương
                    break;
                case 4:
                    manager.printListHistory();
                    break;
                case 5:
                    return;
            }
        }
    }
}

