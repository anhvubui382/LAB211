public class Doctor {
    private String code;
    private String name;
    private String specialization;
    private int availability;

    // Constructor
    public Doctor(String code, String name, String specialization, int availability) {
        setCode(code);
        setName(name);
        setSpecialization(specialization);
        setAvailability(availability);
    }

    // Getters và Setters với điều kiện kiểm tra tính hợp lệ

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor code cannot be null or empty.");
        }
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be null or empty.");
        }
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        if (availability < 0) {
            throw new IllegalArgumentException("Availability must be a positive number.");
        }
        this.availability = availability;
    }

    // Override phương thức toString để hiển thị thông tin bác sĩ
    @Override
    public String toString() {
        return String.format("%-10s%-15s%-25s%-20d", code, name, specialization, availability);
    }
}
