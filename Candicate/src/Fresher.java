
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Fresher extends Candidate {

    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
        super();
    }

    public Fresher(String graduationDate, String graduationRank, String education, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int typeCandidate) throws Exception {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        setEducation(education);
        setGraduationDate(graduationDate);
        setGraduationRank(graduationRank);
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) throws Exception {
        if (graduationDate.isEmpty()) {
            throw new Exception("graduationDate cannot be null");
        }
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) throws Exception {
        // Danh sách các giá trị hợp lệ cho graduationRank
        String[] validRanks = {"Excellence", "Good", "Fair", "Poor"};
        boolean isValid = false;

        // Kiểm tra nếu graduationRank hợp lệ
        for (String validRank : validRanks) {
            if (validRank.equalsIgnoreCase(graduationRank)) {
                isValid = true;
                break;
            }
        }

        // Ném ngoại lệ nếu graduationRank không hợp lệ
        if (!isValid) {
            throw new Exception("Invalid graduation rank. Must be one of: Excellence, Good, Fair, Poor.");
        }

        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) throws Exception {
        if (education.isEmpty()) {
            throw new Exception("Education cannot be null");
        }
        this.education = education;
    }

    public Fresher input() throws Exception {
        Scanner sc = new Scanner(System.in);
        super.input();
         try {
            super.setTypeCandidate(1);
        } catch (Exception ex) {
           
        }
        while (true) {
            try {
                System.out.print("Enter graduation date: ");
                String graduationDate = sc.nextLine().trim();
                setGraduationDate(graduationDate);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter graduation rank: ");
                String rank = sc.nextLine().trim();
                setGraduationRank(rank);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter education: ");
                String education = sc.nextLine().trim();
                setEducation(education);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
       return new Fresher(graduationDate, graduationRank, education, id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
    }
}
