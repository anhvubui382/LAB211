import java.util.HashMap;

public class DoctorHash {
    private HashMap<String, Doctor> doctors;

    public DoctorHash() {
        doctors = new HashMap<>();
    }

    // Add Doctor
    public boolean addDoctor(Doctor doctor) throws Exception {
        if (doctors == null) throw new Exception("Database does not exist");
        if (doctor == null) throw new Exception("Data does not exist");
         if (checkDoctorCodeExists(doctor.getCode())) {
        return false; 
     }
        if (doctors.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code " + doctor.getCode() + " is duplicate");
        }
        doctors.put(doctor.getCode(), doctor);
        return true;
    }

    // Update Doctor
    public boolean updateDoctor(Doctor doctor) throws Exception {
        if (doctors == null) throw new Exception("Database does not exist");
        if (doctor == null) throw new Exception("Data doesn't exist");
        if (!doctors.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code doesn’t exist");
        }
        doctors.put(doctor.getCode(), doctor);
        return true;
    }

    // Delete Doctor
    public boolean deleteDoctor(String code) throws Exception {
        if (doctors == null) throw new Exception("Database does not exist");
        if (code == null) throw new Exception("Data doesn't exist");
        if (!doctors.containsKey(code)) {
            throw new Exception("Doctor code doesn’t exist");
        }
        doctors.remove(code);
        return true;
    }

    // Search Doctor
    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
       
        if (doctors == null) throw new Exception("Database does not exist");
        HashMap<String, Doctor> result = new HashMap<>();
        for (Doctor doctor : doctors.values()) {
            if (doctor.getCode().contains(input) || doctor.getName().contains(input) ||
                doctor.getSpecialization().contains(input)) {
                result.put(doctor.getCode(), doctor);
            }
        }
        return result;
    }

    // Display all doctors (for testing purposes)
    public void displayAllDoctors() {
        for (Doctor doctor : doctors.values()) {
            System.out.println(doctor);
        }
    }
    // Check if Doctor Code Exists
public Boolean checkDoctorCodeExists(String code) throws Exception {
    if (doctors == null) throw new Exception("Database does not exist");
    return doctors.containsKey(code); // Trả về true nếu tồn tại, false nếu không
}

}
