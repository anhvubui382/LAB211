/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author anhvu
 */

import java.util.ArrayList;

/**
 *
 * @author THAYCACAC
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Country> lc = new ArrayList<>();
        //loop until user want to exist
        while (true) {
            int choice = ManageEastAsiaCountries.menu();
            switch (choice) {
                case 1:
                    ManageEastAsiaCountries.inputCountry();
                    break;
                case 2:
                    ManageEastAsiaCountries.printCountry();
                    break;
                case 3:
                    ManageEastAsiaCountries.searchByName();
                    break;
                case 4:
                    ManageEastAsiaCountries.printCountrySorted();
                    break;
                case 5:
                    return;
            }
        }
    }
}