/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author anhvu
 */

import java.util.ArrayList;

/**
 *
 * @author THAYCACAC
 */
public class Main {
 public static int menu() {
        System.out.println("1. Add worker.");
        System.out.println("2. Increase salary for worker.");
        System.out.println("3. Decrease for worker");
        System.out.println("4. Show adjusted salary worker information");
        System.out.println("5. Exist");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputIntLimit(1, 5);
        return choice;
    }
    public static void main(String[] args) throws Exception {
        ArrayList<Worker> lw = new ArrayList<>();
        ArrayList<History> lh = new ArrayList<>();
        //loop until user want to exit
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    Worker.addWorker(lw);
                    break;
                case 2:
                    Worker.changeSalary(lw, lh, 1);
                    break;
                case 3:
                    Worker.changeSalary(lw, lh, 2);
                    break;
                case 4:
                    History.printListHistory(lh);
                    break;
                case 5:
                    return;
            }
        }
    }
}