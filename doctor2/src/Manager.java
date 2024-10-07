

import java.util.ArrayList;

public class Manager {

    // Hiển thị menu
    public static int menu() {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputIntLimit(1, 5);
        return choice;
    }

    // Cho phép người dùng thêm bác sĩ
    public static void addDoctor(ArrayList<Doctor> ld) {
        try {
            System.out.print("Enter code: ");
            String code = Validate.checkInputString();
           

            System.out.print("Enter name: ");
            String name = Validate.checkInputString();
            System.out.print("Enter specialization: ");
            String specialization = Validate.checkInputString();
            System.out.print("Enter availability: ");
            int availability = Validate.checkInputInt();

            ld.add(new Doctor(code, name, specialization, availability));
            System.out.println("Add successful.");
        } catch (Exception e) {
            System.err.println("Error adding doctor: " + e.getMessage());
        }
    }

    // Cho phép người dùng cập nhật thông tin bác sĩ
    public static void updateDoctor(ArrayList<Doctor> ld) {
        try {
            System.out.print("Enter code to update: ");
            String code = Validate.checkInputString();
            Doctor doctor = getDoctorByCode(ld, code);
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

    // Cho phép người dùng xóa bác sĩ
    public static void deleteDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        }
        ld.remove(doctor);
        System.out.println("Delete successful.");
    }

    // Cho phép người dùng tìm kiếm bác sĩ
    public static void searchDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter name: ");
        String nameSearch = Validate.checkInputString();
        ArrayList<Doctor> listFoundByName = listFoundByName(ld, nameSearch);
        if (listFoundByName.isEmpty()) {
            System.err.println("No doctors found.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.println(doctor); // Sử dụng phương thức toString
            }
        }
    }

    // Lấy bác sĩ theo mã
    public static Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    // Lấy danh sách bác sĩ tìm thấy theo tên
    public static ArrayList<Doctor> listFoundByName(ArrayList<Doctor> ld, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
}
