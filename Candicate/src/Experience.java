import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Experience extends Candidate {

    private int yearExperience;
    private String professionalSkill;
    private static final Scanner sc = new Scanner(System.in);

    public Experience() {
        super();
    }

    public Experience(int yearExperience, String professionalSkill,
                      String id, String firstName, String lastName, int birthDate,
                      String address, String phone, String email, int typeCandidate) throws Exception {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        setYearExperience(yearExperience);
        setProfessionalSkill(professionalSkill);
        
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) throws Exception{
        if(yearExperience<0 || yearExperience >100){
            throw new Exception("Year exp must be between 1 to 100");
        }
        this.yearExperience = yearExperience;
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }

    public void input() throws Exception {
        
        // Gọi phương thức input() từ lớp cha để nhập các thông tin chung của Candidate
        super.input();
        try {
            super.setTypeCandidate(0);
        } catch (Exception ex) {
           
        }
       
        // Nhập Year Experience
        int yearExperience = 0;
        while (true) {
            try {
                System.out.print("Enter year experience: ");
                yearExperience = Integer.parseInt(sc.nextLine().trim());
                if (yearExperience < 0) {
                    System.out.println("Experience must be non-negative.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for year experience.");
            }
        }

        // Nhập Professional Skill
        String professionalSkill;
        while (true) {
            try {
                System.out.print("Enter professional skill: ");
                professionalSkill = sc.nextLine().trim();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid professional skill.");
            }
        }

        // Tạo và trả về một đối tượng Experience mới với các thông tin đã nhập
        }
}
