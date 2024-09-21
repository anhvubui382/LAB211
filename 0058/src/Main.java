
import java.util.HashMap;

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
        HashMap<String, String> hm = new HashMap<>();
        //loop until user want to exit
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    Manager.addNewWord(hm);
                    break;
                case 2:
                    Manager.deleteWord(hm);
                    break;
                case 3:
                    Manager.translate(hm);
                    break;
                case 4:
                    return;
            }
        }
    }
    
}
