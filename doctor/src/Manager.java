
import java.util.ArrayList;

/**
 * Class Manager chứa các phương thức quản lý bác sĩ
 */
public class Manager {

    // Hiển thị menu
    public static int menu() {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return Validate.checkInputIntLimit(1, 5);
    }

    // Thêm bác sĩ mới
    public static void addDoctor(ArrayList<Doctor> ld) throws Exception {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        if (!Validate.checkCodeExist(ld, code)) {
            System.err.println("Code exist.");
            return;
        }
        System.out.print("Enter name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = Validate.checkInputString();
        System.out.print("Enter availability: ");
        int availability = Validate.checkInputInt();
        if (!Validate.checkDuplicate(ld, code, name, specialization, availability)) {
            System.err.println("Duplicate.");
            return;
        }
        ld.add(new Doctor(code, name, specialization, availability));
        System.err.println("Add successful.");
    }

    // Cập nhật thông tin bác sĩ
    public static void updateDoctor(ArrayList<Doctor> ld) throws Exception {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        if (Validate.checkCodeExist(ld, code)) {
            System.err.println("Not found doctor");
            return;
        }
        Doctor doctor = getDoctorByCode(ld, code);
        System.out.print("Enter new code: ");
        String codeUpdate = Validate.checkInputString();
        System.out.print("Enter name: ");
        String name = Validate.checkInputString();
        System.out.print("Enter specialization: ");
        String specialization = Validate.checkInputString();
        System.out.print("Enter availability: ");
        int availability = Validate.checkInputInt();
        if (!Validate.checkChangeInfo(doctor, code, name, specialization, availability)) {
            System.err.println("No change");
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful");
    }

    // Xóa bác sĩ
    public static void deleteDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString();
        Doctor doctor = getDoctorByCode(ld, code);
        if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        }
        ld.remove(doctor);
        System.err.println("Delete successful.");
    }

    // Tìm kiếm bác sĩ theo tên
    public static void searchDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter name: ");
        String nameSearch = Validate.checkInputString();
        ArrayList<Doctor> listFoundByName = listFoundByName(ld, nameSearch);
        if (listFoundByName.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
        }
    }

    // Lấy bác sĩ theo mã code
    public static Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    // Lấy danh sách bác sĩ tìm kiếm theo tên
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
