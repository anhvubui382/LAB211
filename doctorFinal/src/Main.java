/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Validate val = new Validate();
        DoctorList docList = new DoctorList();
        Doctor doc = new Doctor();
        while (true) {
            System.out.println("=========Doctor Management=========");
            System.out.println("1.Add doctor");
            System.out.println("2.Update Doctor");
            System.out.println("3.Delete Doctor");
            System.out.println("4.Search Doctor");
            System.out.println("5. Exit");
            int choice = val.checkInputLimit(1, 5);
            switch (choice) {
                case 1:
                    try {
                    System.out.println("---------Add Doctor---------");
                    if (docList.checkValidDoctor(doc.inputDoctor())) {
                        System.out.println("Add Doctor Successfull");
                        docList.addDoctor(doc);
                    } else {
                        System.out.println("Failed to add doctor.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                case 2:
                  try {
                    System.out.println("---------Update Doctor---------");
                    System.out.print("Enter code: ");
                    String checkCode = val.checkInputString();
                    boolean isUpdated = docList.updateDoctor(doc.updateInfo(checkCode));
                    if (isUpdated) {
                        System.out.println("Doctor updated successfully.");
                    } else {
                        System.out.println("Failed to update doctor.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                case 3:
                 try {
                    System.out.println("---------Delete Doctor---------");
                    System.out.print("Enter code: ");
                    String delCode = val.checkInputString();
                    Doctor docFind = docList.findCode(delCode);
                    if (docFind == null) {
                        System.out.println("Failed to delete doctor.");
                    } else {
                        docList.deleteDoctor(delCode);
                        System.out.println("Doctor updated successfully.");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                case 4:
                    try {
                    System.out.println("---------Search Doctor---------");
                    System.out.print("Enter text: ");
                    String searchCode = val.checkInputString();
                    ArrayList<Doctor> list = docList.searchDoctor(searchCode);
                    if (list == null) {
                        System.out.println("Cannot find doctor.");
                    } else {
                        System.out.printf("%-15s%-20s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
                        for (Doctor doctor : list) {
                            System.out.printf("%-15s%-20s%-25s%-20s\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                case 5: return;
            }
        }
    }

}
