
/**
 *
 * @author THAYCACAC
 */
public class Internship extends Candidate {

    private String major;
    private String semester;
    private String university;

    public Internship() {
        super();
    }

    public Internship(String major, String semester, String university,
            String id, String firstName, String lastName, int birthDate,
            String address, String phone, String email, int typeCandidate) throws Exception {
        super(id, firstName, lastName, birthDate, address, phone, email,
                typeCandidate);
        setMajor(major);
        setSemester(semester);
        setUniversity(university);
       
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) throws Exception{
        if(major.isEmpty()){
            throw new Exception("Major cannot be null");
        }
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester)  throws Exception{
        if(semester.isEmpty()){
            throw new Exception("Semester cannot be null");
        }
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university)   throws Exception{
        if(university.isEmpty()){
            throw new Exception("university cannot be null");
        }
        this.university = university;
    }
    
    public Internship input(){
        super.input();
         try {
            super.setTypeCandidate(2);
        } catch (Exception ex) {
           
        }
         while(true){
            try {
                System.out.print("Enter major: ");
                String major = sc.nextLine().trim();
                setMajor(major);
                break;
            } catch (Exception e) {
            }
        }
         while(true){
            try {
                System.out.print("Enter semester: ");
                String semester = sc.nextLine().trim();
                setSemester(semester);
                break;
            } catch (Exception e) {
            }
        }
        while(true){
            try {
                System.out.print("Enter university: ");
                String university = sc.nextLine().trim();
                setUniversity(university);
                break;
            } catch (Exception e) {
            }
        }
         return this;
    }
}