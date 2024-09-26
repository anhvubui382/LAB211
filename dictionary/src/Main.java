import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== Simple English-Vietnamese Dictionary =====");
            System.out.println("1. Add new word");
            System.out.println("2. Delete word");
            System.out.println("3. Search word");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter English word: ");
                    String eng = scanner.nextLine();
                    System.out.print("Enter Vietnamese translation: ");
                    String vi = scanner.nextLine();
                    dictionary.addWord(eng, vi);
                    break;
                case 2:
                    System.out.print("Enter English word to remove: ");
                    String wordToRemove = scanner.nextLine();
                    dictionary.removeWord(wordToRemove);
                    break;
                case 3:
                    System.out.print("Enter English word to translate: ");
                    String wordToTranslate = scanner.nextLine();
                    String translation = dictionary.translate(wordToTranslate);
                    System.out.println("Vietnamese translation: " + translation);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 4);
    }
}
