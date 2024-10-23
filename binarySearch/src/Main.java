
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
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        BinarySearch bs = new BinarySearch();
        bs.inputSize(sc);
        bs.random();
        
        System.out.println("Enter search value: ");
        int search = sc.nextInt();
        System.out.println("Sorted array: ");
        
        int result = bs.binarySearch(search);
        
        if(result != -1){
            System.out.println("\nFound " + search + "at index " + result);
        } else {
            System.out.println("\nNot found");
        }
    }
    
}
