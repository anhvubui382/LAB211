
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
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
                    while (true) {
                        Experience exp = new Experience();
                        exp.input();
                        candidateList.addCandidate(exp);

                        System.out.print("Do you want to add another experience candidate? (Y/N): ");
                        String yn = sc.nextLine().trim().toUpperCase();

                        if (yn.equals("N")) {
                            break; // Exit the loop if user chooses "N"
                        } else if (!yn.equals("Y")) {
                            System.out.println("Invalid input. Please enter Y or N.");
                        }
                    }
                    break;

                case 2: // Fresher
                    while (true) {
                        Fresher fresher = new Fresher();
                        fresher.input();
                        candidateList.addCandidate(fresher);

                        System.out.print("Do you want to add another experience candidate? (Y/N): ");
                        String yn = sc.nextLine().trim().toUpperCase();

                        if (yn.equals("N")) {
                            break; // Exit the loop if user chooses "N"
                        } else if (!yn.equals("Y")) {
                            System.out.println("Invalid input. Please enter Y or N.");
                        }
                    }
                    break;

                case 3: // Intern
                    while (true) {
                        Internship intern = new Internship();
                        intern.input();
                        candidateList.addCandidate(intern);

                        System.out.print("Do you want to add another experience candidate? (Y/N): ");
                        String yn = sc.nextLine().trim().toUpperCase();

                        if (yn.equals("N")) {
                            break; // Exit the loop if user chooses "N"
                        } else if (!yn.equals("Y")) {
                            System.out.println("Invalid input. Please enter Y or N.");
                        }
                    }

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
        }

    }
}
