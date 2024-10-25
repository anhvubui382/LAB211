

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class Doctor {

    private Scanner sc = new Scanner(System.in);
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
        setCode(sc.nextLine().trim());
        System.out.print("Enter name: ");
        setName(sc.nextLine().trim());
        System.out.print("Enter special: ");
        setSpecialization(sc.nextLine().trim());
        System.out.print("Enter availibilyti: ");
        setAvailability(sc.nextInt());
        return new Doctor(code, name, specialization, availability);
    }

    public Doctor updateInfo(String code) throws Exception {
        this.code = code;
        System.out.print("Enter new name: ");
        
        setName(sc.nextLine().trim());

        System.out.print("Enter new specialization: ");
        setSpecialization(sc.nextLine().trim());

        System.out.print("Enter new availability: ");
        setAvailability(sc.nextInt());

        return new Doctor(code, name, specialization, availability);
    }

    @Override
    public String toString() {
        return String.format("%-15s%-20s%-25s%-20s\n", code, name, specialization, availability);
    }
    
 
}
