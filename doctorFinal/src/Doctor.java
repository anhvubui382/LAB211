/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class Doctor {

    Validate val = new Validate();
    private String code, name, specialization;
    private int availability;

    public Doctor() {
    }

    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setCode(String code) throws Exception {
        if (code.isEmpty()) {
            throw new Exception("Cannot be empty");
        }
        this.code = code;
    }

    public void setName(String name) throws Exception {
        if (name.isEmpty()) {
            throw new Exception("Cannot be empty");
        }
        this.name = name;
    }

    public void setSpecialization(String specialization) throws Exception {
        if (specialization.isEmpty()) {
            throw new Exception("Cannot be empty");
        }
        this.specialization = specialization;
    }

    public void setAvailability(int availability) throws Exception {
        if (availability <= 0) {
            throw new Exception("Cannot be empty");
        }
        this.availability = availability;
    }

    public Doctor inputDoctor() throws Exception {
        System.out.print("Enter Code: ");
        setCode(val.checkInputString());
        System.out.print("Enter name: ");
        setName(val.checkInputString());
        System.out.print("Enter special");
        setSpecialization(val.checkInputString());
        System.out.print("Enter Availibilyti");
        setAvailability(val.checkInputInt());
        return new Doctor(code, name, specialization, availability);
    }

    public Doctor updateInfo(String code) throws Exception {
        this.code = code;
        System.out.print("Enter new name: ");
        setName(val.checkInputString());

        System.out.print("Enter new specialization: ");
        setSpecialization(val.checkInputString());

        System.out.print("Enter new availability: ");
        setAvailability(val.checkInputInt());

        return new Doctor(code, name, specialization, availability);
    }
    
     public void display(){
        System.out.printf("%-15s%-20s%-25s%-20s\n", code, name, specialization, availability);
    }
}
