
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Ebank {

   
    private String accountNumber;
    private String password;
    private Locale currentLocale;
    private ResourceBundle messages;
    private EbankHelper ebankHelper = new EbankHelper();
    Scanner scanner = new Scanner(System.in);

    // Constructor
    public Ebank(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public Ebank() {
        setLocale(new Locale("en", "")); // Default to English
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
            throw new Exception(ebankHelper.getWordLanguage(locale, "errorInputEmpty"));
        }
        if(ebankHelper.checkAccountNumber(accountNumber)==null){
            throw new Exception(ebankHelper.getWordLanguage(locale, "errorAccountNumber"));
        }

        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password, Locale locale) throws Exception {
        if (password.isEmpty()) {
            throw new Exception(ebankHelper.getWordLanguage(locale, "errorInputEmpty"));
        }
        if(ebankHelper.checkPasword(password)==null){
            throw new Exception(ebankHelper.getWordLanguage(locale, "errorPasswordLength"));
        }
        this.password = password;
    }

  

    // Method to input account information from user
    public Ebank inputAccount(Locale language) {
        while (true) {
            try {
                System.out.print(ebankHelper.getWordLanguage(language, "promptEnterAccountNumber"));
                String inputAccountNumber = scanner.nextLine();
                setAccountNumber(inputAccountNumber, language);
                
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print(ebankHelper.getWordLanguage(language, "promptEnterPassword"));
                String inputPassword = scanner.nextLine();
                setPassword(inputPassword, language);
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        return new Ebank(accountNumber, password);
    }

    
}
