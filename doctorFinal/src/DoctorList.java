/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DoctorList {

    ArrayList<Doctor> doctorlist = new ArrayList<>();

    public boolean checkValidDoctor(Doctor inputDoctor) {
        for (Doctor doctor1 : doctorlist) {
            if (doctor1.getCode().equals(inputDoctor.getCode())) {
                return true;
            }
        }
        return false;
    }

    public void addDoctor(Doctor doc) {
        doctorlist.add(doc);
        
    }

    public Doctor findCode(String delCode) {
        for (Doctor doctor : doctorlist) {
            if (doctor.getCode().equals(delCode)) {
                return doctor;
            }
        }
        return null;
    }

    public void deleteDoctor(String delCode) {
        for (Doctor doctor : doctorlist) {
            if (doctor.equals(findCode(delCode))) {
                doctorlist.remove(doctor);
                break;
            }
        }
    }

   public ArrayList<Doctor> searchDoctor(String searchCode) throws Exception {
  
    if (doctorlist.isEmpty()) {
        throw new Exception("Database does not exist");
    }

    ArrayList<Doctor> listFound = new ArrayList<>();
    
    // Duyệt qua danh sách bác sĩ và tìm bác sĩ chứa từ khóa tìm kiếm
    for (Doctor doctor : doctorlist) {
        if (doctor.getName().toLowerCase().contains(searchCode.toLowerCase()) 
            || doctor.getCode().toLowerCase().contains(searchCode.toLowerCase())) {
            listFound.add(doctor);
        }
    }
    
    return listFound;
}


    public void displayDoctor() {
        for (Doctor d : doctorlist) {
            System.out.println(d);
        }
    }

public boolean updateInfoDoctor(String code) throws Exception {
    // Tìm kiếm bác sĩ theo mã
    Doctor existingDoctor = findCode(code);
    if (existingDoctor == null) {
        throw new Exception("Doctor with code " + code + " does not exist.");
    }
    
    // Nhập thông tin mới từ người dùng
    Doctor updatedDoctor = existingDoctor.updateInfo(code);
    
    // Cập nhật thông tin trong danh sách
    for (int i = 0; i < doctorlist.size(); i++) {
        if (doctorlist.get(i).getCode().equals(code)) {
            doctorlist.set(i, updatedDoctor);
            System.out.println("Doctor information updated successfully.");
            return true;
        }
    }
    throw new Exception("Failed to update doctor information.");
}

}
