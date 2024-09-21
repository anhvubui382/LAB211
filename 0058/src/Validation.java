
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anhvu
 */
public class Validation {
    private final static Scanner in = new Scanner(System.in);
    
    public static int checkInputIntLimit(int min, int max){
        while(true){
            try{
                int result = Integer.parseInt(in.nextLine().trim());
                if(result < min || result > max){
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e){
                 System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
     public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
      public static boolean checkInputYN() {
        System.out.print("Do you want to replace(Y/N)? ");
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
}
