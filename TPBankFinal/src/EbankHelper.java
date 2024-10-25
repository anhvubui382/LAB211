
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author anhvu
 */
public class EbankHelper {

    Scanner scanner = new Scanner(System.in);

    private static final String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
    private static final String PASSWORD_VALID = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,31}$";
    private static final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};
    private static Ebank ebank;

    public String getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words = ResourceBundle.getBundle("" + curLocate, curLocate);
        String value = words.getString(key);
        return value;

    }

    public String checkPasword(String password) {
        if (!password.matches(PASSWORD_VALID)) {
           
            return null;
        }
        return password;
    }

    public String checkAccountNumber(String accountNumber) {
        if (!accountNumber.matches(ACCOUNT_NUMBER_VALID)) {
            return null;
        }
        return accountNumber;
    }

    public void login(Ebank ebank) {
      
        String captchaGenerated = generateCaptcha();

     
        System.out.println("CAPTCHA: " + captchaGenerated);

        // Loop until the user provides correct input for the CAPTCHA
        while (true) {
            if (checkInputCaptcha(captchaGenerated, ebank.getCurrentLocale()) != null) {
                System.out.println(getWordLanguage(ebank.getCurrentLocale(), "loginSuccessMessage"));
                return;
            } else {
                System.out.println(getWordLanguage(ebank.getCurrentLocale(), "errorCaptchaIncorrect"));
                // Re-generate and display the CAPTCHA for the user to attempt again
                captchaGenerated = generateCaptcha();
                System.out.print("Enter new CAPTCHA: " + captchaGenerated);
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
