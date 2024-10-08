
import java.util.ArrayList;

public class Doctor {
    private String code;
    private String name;
    private String specialization;
    private int availability; // Kiểu nguyên thủy int
    private static  ArrayList<Doctor> ld = new ArrayList<>();
    public Doctor() {
    }

    // Constructor
    public Doctor(String code, String name, String specialization, int availability) throws Exception {
        setCode(code);
        setName(name);
        setSpecialization(specialization);
        setAvailability(availability);
    }

    // Getter và Setter với kiểm tra hợp lệ dữ liệu

    public String getCode() {
        return code;
    }

    public void setCode(String code) throws Exception {
        if (code == null || code.trim().isEmpty()) {
            throw new Exception("Doctor code cannot be null or empty.");
        }
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Doctor name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) throws Exception {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new Exception("Specialization cannot be null or empty.");
        }
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) throws Exception {
        if (availability < 0) {
            throw new Exception("Availability must be a non-negative number.");
        }
        this.availability = availability;
    }

    // Override phương thức toString để hiển thị thông tin bác sĩ
    @Override
    public String toString() {
        return String.format("%-10s%-15s%-25s%-20d", code, name, specialization, availability);
    }
    // Cho phép người dùng thêm bác sĩ
    public static void addDoctor() {
        try {
             Doctor newDoctor = new Doctor();

        // Set code
        System.out.print("Enter code: ");
        newDoctor.setCode(Validate.checkInputString());
      
        // Set name
        System.out.print("Enter name: ");
    
        newDoctor.setName(Validate.checkInputString());
    
        System.out.print("Enter specialization: ");
       
        newDoctor.setSpecialization(Validate.checkInputString()); // Call the setSpecialization() method

        // Set availability
        System.out.print("Enter availability: ");
        
        newDoctor.setAvailability(Validate.checkInputInt()); // Call the setAvailability() method

        // Add the new doctor to the list
        ld.add(newDoctor);
        System.out.println("Add successful.");
        } catch (Exception e) {
            System.err.println("Error adding doctor: " + e.getMessage());
        }
    }

    // Cho phép người dùng cập nhật thông tin bác sĩ
    public static void updateDoctor() {
        try {
            System.out.print("Enter code to update: ");
            String code = Validate.checkInputString();
            Doctor doctor = getDoctorByCode(code);
            if (doctor == null) {
                System.err.println("Not found doctor.");
                return;
            }

            System.out.print("Enter new name (leave blank to keep current): ");
            String name = Validate.checkInputString();
            if (!name.isEmpty()) {
                doctor.setName(name);
            }

            System.out.print("Enter new specialization (leave blank to keep current): ");
            String specialization = Validate.checkInputString();
            if (!specialization.isEmpty()) {
                doctor.setSpecialization(specialization);
            }

            System.out.print("Enter new availability (leave blank to keep current): ");
            String availabilityInput = Validate.checkInputString();
            if (!availabilityInput.isEmpty()) {
                int availability = Integer.parseInt(availabilityInput);
                doctor.setAvailability(availability);
            }

            System.out.println("Update successful.");
        } catch (Exception e) {
            System.err.println("Error updating doctor: " + e.getMessage());
        }
    }
 // Lấy bác sĩ theo mã
    public static Doctor getDoctorByCode(String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    // Lấy danh sách bác sĩ tìm thấy theo tên
    public static ArrayList<Doctor> listFoundByName(String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
    // Cho phép người dùng xóa bác sĩ
    public static void deleteDoctor() {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        
        Doctor doctor = getDoctorByCode(code);
        if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        }
        ld.remove(doctor);
        System.out.println("Delete successful.");
    }

    // Cho phép người dùng tìm kiếm bác sĩ
    public static void searchDoctor() {
        System.out.print("Enter name: ");
        String nameSearch = Validate.checkInputString();
        ArrayList<Doctor> listFoundByName = listFoundByName(nameSearch);
        if (listFoundByName.isEmpty()) {
            System.err.println("No doctors found.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.println(doctor); // Sử dụng phương thức toString
            }
        }
    }
}
