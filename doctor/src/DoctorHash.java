import java.util.ArrayList;
import java.util.HashMap;

public class DoctorHash {
     private final HashMap<String, Doctor> doctorMap = new HashMap<>();

    public ArrayList<Doctor> getDoctorList() {
        return new ArrayList<>(doctorMap.values());
    }

    public void addDoctor(Doctor doctor) {
        doctorMap.put(doctor.getCode(), doctor);
    }

    public HashMap<String, Doctor> searchDoctor(String code) {
        HashMap<String, Doctor> result = new HashMap<>();
        for (Doctor doctor : doctorMap.values()) {
            if (doctor.getCode().equalsIgnoreCase(code)
                    || doctor.getName().toLowerCase().contains(code.toLowerCase())
                    || doctor.getSpecialization().toLowerCase().contains(code.toLowerCase())) {
                result.put(doctor.getCode(), doctor);
            }
        }
        return result;
    }

    public void updateDoctor(Doctor doctor) {
        doctorMap.put(doctor.getCode(), doctor);
    }

    public void deleteDoctor(String code) {
        doctorMap.remove(code);
    }
}
