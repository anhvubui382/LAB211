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
        for (Doctor doctor : doctorlist) {
            if (doctor.getName().equalsIgnoreCase(searchCode) || doctor.getCode().equalsIgnoreCase(searchCode)) {
                listFound.add(doctor);
            }
        }
        return listFound;
    }

    public void displayDoctor() {
        for (Doctor d : doctorlist) {
            d.display();
        }
    }

    boolean updateDoctor(Doctor updateInfo) throws Exception {
        if (doctorlist.isEmpty()) {
            throw new Exception("Database does not exist");
        }
        if (updateInfo == null) {
            throw new Exception("Data does not exist");
        }
        if (!doctorlist.contains(updateInfo.getCode())) {
            throw new Exception("Doctor code doesn’t exist");
        }
        int index = -1;
        for (int i = 0; i < doctorlist.size(); i++) {
            if (doctorlist.get(i).getCode().equals(updateInfo.getCode())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new Exception("Doctor code doesn’t exist");
        }
        doctorlist.set(index, updateInfo);
        return true;
    }

}
