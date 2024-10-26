
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidateList {

    private List<Candidate> candidates;

    public CandidateList() {
        this.candidates = new ArrayList<>();
    }

    // Thêm ứng viên vào danh sách
    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    // Hiển thị danh sách ứng viên
public void displayCandidates() {
    if (candidates.isEmpty()) {
        System.out.println("No candidates available.");
        return;
    }

    // In tiêu đề cho từng loại ứng viên
    System.out.println("===========EXPERIENCE CANDIDATE============");
    for (Candidate candidate : candidates) {
        if (candidate instanceof Experience) {
            System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
        }
    }

    System.out.println("==========FRESHER CANDIDATE==============");
    for (Candidate candidate : candidates) {
        if (candidate instanceof Fresher) {
            System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
        }
    }

    System.out.println("===========INTERN CANDIDATE==============");
    for (Candidate candidate : candidates) {
        if (candidate instanceof Internship) {
            System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
        }
    }
}



    public void searchCandidates(String nameInput, int typeInput) {
       
        boolean found = false;
        
        for (Candidate candidate : candidates) {
            if ((candidate.getFirstName().toLowerCase().contains(nameInput)
                    || candidate.getLastName().toLowerCase().contains(nameInput))
                    && candidate.getTypeCandidate() == typeInput) {
                System.out.println(candidate);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No candidates found matching your criteria.");
        }
    }
   private static int getTypeInput(Scanner sc) {
        int typeInput;
        while (true) {
            try {
                typeInput = Integer.parseInt(sc.nextLine());
                if (typeInput < 0 || typeInput > 2) {
                    throw new NumberFormatException();
                }
                break; // Thoát vòng lặp nếu nhập hợp lệ
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid type (0, 1, or 2): ");
            }
        }
        return typeInput;
    }
}
