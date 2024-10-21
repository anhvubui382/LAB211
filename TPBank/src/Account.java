import java.util.Scanner;

public class Account {

    private String username;
    private String password;
    Scanner scanner = new Scanner(System.in);

    // Constructor
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws Exception {
        if (username.isEmpty()) {
            throw new Exception("Username cannot be null.");
        }

        // Ensure the username is a 10-digit number (account number)
        String ACCOUNT_NUMBER_VALID = "\\d{10}";
        if (!username.matches(ACCOUNT_NUMBER_VALID)) {
            throw new Exception("Account number must be a 10-digit number.");
        }

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if (password.isEmpty()) {
            throw new Exception("Password cannot be null.");
        }

        // Ensure the password is between 8 and 31 characters and alphanumeric
        String PASSWORD_VALID = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,31}$";
        if (!password.matches(PASSWORD_VALID)) {
            throw new Exception("Password must be between 8 and 31 characters and contain both letters and numbers.");
        }

        this.password = password;
    }

    // Method to input account information from user
    public Account inputAccount() {
        Account account = new Account();

        try {
            // Input for username
            System.out.print("Enter your account number (10 digits): ");
            String inputUsername = scanner.nextLine();
            account.setUsername(inputUsername);

            // Input for password
            System.out.print("Enter your password (8-31 characters, must include letters and numbers): ");
            String inputPassword = scanner.nextLine();
            account.setPassword(inputPassword);

        } catch (Exception e) {
            // Handle any invalid input by printing the exception message
            System.out.println("Error: " + e.getMessage());
        }

        return account;
    }
}
