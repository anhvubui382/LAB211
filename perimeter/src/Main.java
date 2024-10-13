
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
    private Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle rt = new Rectangle();
        rt.Input();
        Circle c = new Circle();
        c.Input();
        Triangle tr = new Triangle();
        tr.Input();
        rt.printResult();
        tr.printResult();
        c.printResult();
    }
    
}
