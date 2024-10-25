import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ebank ebank = new Ebank();
        EbankHelper eh = new EbankHelper();
        Locale locale;

        while (true) {
            System.out.println("-------- Login Program --------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");

            int languageChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (languageChoice) {
                case 1:
                    locale = new Locale("vi");
                    ebank.inputAccount(locale);
                    eh.login(ebank);
                    break;
                case 2:
                    locale = new Locale("en");
                    ebank.inputAccount(locale);
                    eh.login(ebank);
                    break;
                case 3:
                    System.out.println("Exiting the program. Thank you!");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please select again.");
                    continue; // Ask for input again
            }

            
        }
    }
}
