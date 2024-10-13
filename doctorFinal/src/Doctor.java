public class Doctor {
    private String code;
    private String name;
    private String specialization;
    private int availability;

    public Doctor() {
    }

    // Constructor
    public Doctor(String code, String name, String specialization, int availability) throws Exception {
        setCode(code);
        setName(name);
        setSpecialization(specialization);
        setAvailability(availability);
    }

    // Getters and Setters with validation

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

    // Override toString method to display doctor information
    @Override
    public String toString() {
        return String.format("%-10s%-15s%-25s%-20d", code, name, specialization, availability);
    }
    
}
