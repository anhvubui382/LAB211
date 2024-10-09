
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author anhvu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static final Scanner in = new Scanner(System.in);
    private static final String PHONE_VALID = "^\\d{9,10}$";
    private static final String EMAIL_VALID = "^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$";
    private static final ArrayList<Account> la = new ArrayList<>();
    private static final Account account = new Account();
    private static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter in range [" + min + ", " + max + "]");
            }
        }
    }

    private static String checkInputDate() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.out.println("Please enter date with dd/MM/yyyy");
                }
            } catch (NumberFormatException | ParseException ex) {
                System.out.println("Please enter date with dd/MM/yyyy");
            }
        }
    }

    private static String checkInputEmail() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() != 0 && result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.out.println("Email must be include @");
            }
        }
    }

    private static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.out.println("Not empty");
            } else {
                return result;
            }
        }
    }

    private static String checkInputPhone() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() != 0 && result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.out.println("Please enter phone number 9 10 lenths");
            }
        }
    }

    private static String checkInputUsername() throws Exception {
        while (true) {
            String result = checkInputString();
            for (int i = 0; i < la.size(); i++) {
                if (result.equalsIgnoreCase(la.get(i).getUsername())) {
                    System.out.println("Username already exsists!!!");
                    return "";
                }
            }
            return result;
        }
    }

    private static String MD5Encryption(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static void addAccount(ArrayList<Account> la) throws Exception {
//        Account account = new Account();
        System.out.println("Enter username: ");
        account.setUsername(checkInputUsername());
//        String username = checkInputUsername();
        System.out.println("Enter password: ");
        account.setPassword(checkInputString());
//        String password = checkInputString();

        System.out.println("Enter name: ");
        account.setName(checkInputString());
        System.out.println("Enter phone: ");
     
        account.setPhone(checkInputPhone());
        System.out.println("Enter email: ");
        account.setEmail(checkInputEmail());
       
        System.out.println("Enter address: ");
        account.setAddress(checkInputString());
       
        System.out.println("Enter Date of birth: ");
        String dateOfBirth = checkInputDate();
        account.setDateOfBirth(checkInputDate());
        la.add(account);
        System.out.println("Add success!!!");
    }

    private static void login() throws Exception {
        if (la.isEmpty()) {
            System.out.println("Account empty");
            return;
        }
        System.out.println("Enter username: ");
        String username = checkInputString();
        System.out.println("Enter password: ");
        String password = checkInputString();
        Account accountLogin = findAccount(la, username, password);
        if (accountLogin != null) {
            System.out.println("Welcome!!!");
            System.out.println("Hi" + accountLogin.getUsername()
                    + ", do you want to change your password now? Y/N: ");

        }
    }

    private static void changePassword(Account accountLogin) throws Exception {
        String choice;
        while (true) {
            choice = in.nextLine().trim();
            if (choice.length() == 0) {
                System.out.println("Not empty!!!");
            } else if (choice.length() == 1 && choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Re-input");
            }
        }
        if(choice.equalsIgnoreCase("Y")){
            System.out.println("Old password: ");
            String oldPassword = checkInputString();
            System.out.println("New password: ");
            String newPassword = checkInputString();
            System.out.println("Re-enter new password: ");
            String renewPassword = checkInputString();
            if(!MD5Encryption(oldPassword).equalsIgnoreCase(accountLogin.getPassword())){
                System.err.println("Old password incorrect.");
            }
            if (!newPassword.equalsIgnoreCase(renewPassword)) {
                System.err.println("New password and Re-entered password do not match.");
            }
            if (MD5Encryption(oldPassword).equalsIgnoreCase(accountLogin.getPassword())
                    && newPassword.equalsIgnoreCase(renewPassword)) {
                accountLogin.setPassword(MD5Encryption(newPassword));
                System.out.println("Password changed successfully");
            }
        }
    }
    private static void display() throws Exception{
        ArrayList<Account> la = new ArrayList<>();
        while(true){
            System.out.println("1. Add user");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int choice = checkIntLimit(1, 3);
            switch(choice){
                case 1: 
                    addAccount(la);
                    break;
                case 2: 
                    login();
                    break;
                case 3:
                    return;
            }
        }
    }

    private static Account findAccount(ArrayList<Account> la, String username, String password) throws Exception {
        for (Account account : la) {
            if (username.equalsIgnoreCase(account.getUsername())) {
                if (MD5Encryption(password).equalsIgnoreCase(account.getPassword())) {
                    return account;
                } else {
                    return null;
                }
            }

        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        display();
    }

}
