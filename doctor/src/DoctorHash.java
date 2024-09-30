import java.util.HashMap;

public class DoctorHash {
    private HashMap<String, Doctor> doctors = new HashMap<>();

    // Thêm bác sĩ vào danh sách
    public void addDoctor(Doctor doctor) {
        if (doctors.containsKey(doctor.getCode())) {
            throw new IllegalArgumentException("Doctor code already exists.");
        }
        doctors.put(doctor.getCode(), doctor);
    }

    // Cập nhật thông tin bác sĩ
    public void updateDoctor(Doctor doctor) {
        if (!doctors.containsKey(doctor.getCode())) {
            throw new IllegalArgumentException("Doctor does not exist.");
        }
        doctors.put(doctor.getCode(), doctor);
    }

    // Xóa bác sĩ
    public void deleteDoctor(String code) {
        if (!doctors.containsKey(code)) {
            throw new IllegalArgumentException("Doctor code not found.");
        }
        doctors.remove(code);
    }

    // Tìm kiếm bác sĩ theo mã hoặc tên
    public HashMap<String, Doctor> searchDoctor(String search) {
        HashMap<String, Doctor> result = new HashMap<>();
        for (Doctor doctor : doctors.values()) {
            if (doctor.getCode().equalsIgnoreCase(search) || 
                doctor.getName().toLowerCase().contains(search.toLowerCase())) {
                result.put(doctor.getCode(), doctor);
            }
        }
        return result;
    }

    // Trả về tất cả bác sĩ trong danh sách
    public HashMap<String, Doctor> getAllDoctors() {
        return doctors;
    }
}
