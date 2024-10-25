
import java.util.Scanner;

public class Doctor {
    private String code;
    private String name;
    private String specialization;
    private int availability;
    Scanner sc = new Scanner(System.in);
    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    Doctor() {
        }

    public String getCode() {
        return code;
    }

    public void setCode(String code) throws Exception{
        if(code.isEmpty()){
            throw new Exception("Code cannot be null");
        }
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name)  throws Exception{
        if(name.isEmpty()){
            throw new Exception("name cannot be null");
        }
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization)  throws Exception{
        if(specialization.isEmpty()){
            throw new Exception("specialization cannot be null");
        }
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) throws Exception {
        if(availability <=0 ){
            throw new Exception("Availability must be greater than 0");
        }
        this.availability = availability;
    }

    @Override
    public String toString() {
         return String.format("%-15s%-20s%-25s%-20s\n", code, name, specialization, availability);
    }
    
    public Doctor inputDoctor(){
        while(true){
            try {
                System.out.println("Enter code: ");
                String code = sc.nextLine().trim();
                setCode(code);
                break;
            } catch (Exception e) {
            }
        }
         while(true){
            try {
                System.out.println("Enter name: ");
                String name = sc.nextLine().trim();
                setName(name);
                break;
            } catch (Exception e) {
            }
        }
         while(true){
            try {
                System.out.println("Enter specialization: ");
                String specialization = sc.nextLine().trim();
                setSpecialization(specialization);
                break;
            } catch (Exception e) {
            }
        }
          while(true){
            try {
                System.out.println("Enter availability: ");
                int availability = sc.nextInt();
                setAvailability(availability);
                break;
            } catch (Exception e) {
            }
        }
          return new Doctor(code, name, specialization, availability);
    }
      public void updateDoctorDetails() {
        try {
            System.out.print("Enter new Name (or leave blank to keep current): ");
            String newName = sc.nextLine().trim();
            if (!newName.isEmpty()) setName(newName);

            System.out.print("Enter new Specialization (or leave blank to keep current): ");
            String newSpecialization = sc.nextLine().trim();
            if (!newSpecialization.isEmpty()) setSpecialization(newSpecialization);

            System.out.print("Enter new Availability (or leave blank to keep current): ");
            String availInput = sc.nextLine().trim();
            if (!availInput.isEmpty()) setAvailability(Integer.parseInt(availInput));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
