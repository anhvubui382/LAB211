
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CandidateList candidateList = new CandidateList();

        while (true) {
            System.out.println("======== CANDIDATE MANAGEMENT SYSTEM ========");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Intern");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("Please choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1: // Experience
                    candidateList.addCandidate(new Experience().input());
                    break;
                case 2: // Fresher
                    candidateList.addCandidate(new Fresher().input());
                    break;
                case 3: // Intern
                    candidateList.addCandidate(new Internship().input());
                    break;

                case 4: // Searching
                    candidateList.displayCandidates();
                    System.out.print("Input candidate name (First name or Last name): ");
                    String nameInput = sc.nextLine().toLowerCase();

                    System.out.print("Input type of candidate: ");
                    int typeInput = Integer.parseInt(sc.nextLine());
                    if (typeInput < 0 || typeInput > 2) {
                        System.out.println("Must be 0, 1, 2");
                    }
                    candidateList.searchCandidates(nameInput, typeInput);

                    break;
                case 5:
                    System.out.println("Exiting program.");
                    sc.close(); // Đóng Scanner để tránh rò rỉ tài nguyên
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Nhắc người dùng có muốn tiếp tục hay không
            System.out.print("Do you want to continue (Y/N)? ");
            String continueChoice = sc.nextLine();
            if (continueChoice.equalsIgnoreCase("N")) {

                continue;
            }
        }

    }
}
