/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        DoctorList docList = new DoctorList();
        Doctor doc = new Doctor();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=========Doctor Management=========");
            System.out.println("1.Add doctor");
            System.out.println("2.Update Doctor");
            System.out.println("3.Delete Doctor");
            System.out.println("4.Search Doctor");
            System.out.println("5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    try {
                    System.out.println("---------Add Doctor---------");
                    doc.inputDoctor();
                    docList.addDoctor(doc);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                case 2:
                   try {
                    System.out.println("---------Update Doctor---------");
                    System.out.print("Enter code: ");
                    String checkCode = sc.nextLine().trim();
                    boolean result = docList.updateInfoDoctor(checkCode);
                    if (result) {
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
                    String delCode = sc.nextLine();
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
                    String searchCode = sc.nextLine().trim();
                    ArrayList<Doctor> list = docList.searchDoctor(searchCode);
                    if (list == null) {
                        System.out.println("Cannot find doctor.");
                    } else {
                        System.out.printf("%-15s%-20s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
                        for (Doctor doctor : list) {
                            System.out.println(doctor);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                case 5:
                    return;
            }
        }
    }

}
