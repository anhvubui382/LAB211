
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Ebank {

    private static final String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
    private static final String PASSWORD_VALID = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,31}$";
    private static final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};

    private String accountNumber;
    private String password;
    private Locale currentLocale;
    private ResourceBundle messages;

    Scanner scanner = new Scanner(System.in);

    // Constructor
    public Ebank(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public Ebank() {
        setLocale(new Locale("en", "EN")); // Default to English
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setLocale(Locale locale) {
        this.currentLocale = locale;
        this.messages = ResourceBundle.getBundle("MessagesBundle", locale);
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber, Locale locale) throws Exception {
        if (accountNumber.isEmpty()) {
            throw new Exception(getWordLanguage(locale, "errorInputEmpty"));
        }

        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password, Locale locale) throws Exception {
        if (password.isEmpty()) {
            throw new Exception(getWordLanguage(locale, "errorInputEmpty"));
        }

        this.password = password;
    }

    public String getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words = ResourceBundle.getBundle("" + curLocate, curLocate);
        String value = words.getString(key);
        return value;

    }

    public String checkPasword(String password) {
        if (!password.matches(PASSWORD_VALID)) {
            System.out.println(getWordLanguage(getCurrentLocale(), "errorPasswordLength"));
            return null;
        }
        return password;
    }

    public String checkAccountNumber(String accountNumber) {
        if (!accountNumber.matches(ACCOUNT_NUMBER_VALID)) {

            System.out.println(getWordLanguage(getCurrentLocale(), "errorAccountNumber"));
            return null;
        }
        return accountNumber;
    }

    // Method to input account information from user
    public Ebank inputAccount(Locale language) {
        while (true) {
            try {
                System.out.println(getWordLanguage(language, "promptEnterAccountNumber"));
                String inputAccountNumber = scanner.nextLine();
                setAccountNumber(inputAccountNumber, language);
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println(getWordLanguage(language, "promptEnterPassword"));
                String inputPassword = scanner.nextLine();
                setPassword(inputPassword, language);
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        return new Ebank(accountNumber, password);
    }

    public void login(Locale language) {
        inputAccount(language);
        String captchaGenerated = generateCaptcha();

        // Display the generated CAPTCHA
        System.out.println("CAPTCHA: " + captchaGenerated);

        // Loop until the user provides correct input for the CAPTCHA
        while (true) {
            if (checkInputCaptcha(captchaGenerated, language) != null) {
                System.out.println(getWordLanguage(language, "loginSuccessMessage"));
                return;
            } else {
                System.out.println(getWordLanguage(language, "errorCaptchaIncorrect"));
                // Re-generate and display the CAPTCHA for the user to attempt again
                captchaGenerated = generateCaptcha();
                System.out.println("CAPTCHA: " + captchaGenerated);
            }
        }
    }

    public String checkInputCaptcha(String captchaGenerated, Locale language) {
        System.out.println(getWordLanguage(language, "promptEnterCaptcha"));
        // Get the user input for CAPTCHA
        String captchaInput = scanner.nextLine(); // Change to read user input
        if (!captchaInput.equals(captchaGenerated)) {
            return null;
        }
        // Validate the input against the generated CAPTCHA
        return captchaInput;
    }

    static String generateCaptcha() {

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < 6; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }

}
