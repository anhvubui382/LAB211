import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ListAccount {
    private static final Scanner in = new Scanner(System.in);
    private static final String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
    private static final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};

    static String checkInputString(Locale language) {
        while (true) {
            String result = in.nextLine();
            if (result.length() == 0) {
                getWordLanguage(language, "errorCheckInput");
                System.out.println();
            } else {
                return result;
            }
        }
    }

    static int checkInputAccount(Locale language) {
        while (true) {
            String result = in.nextLine();
            if (result.matches(ACCOUNT_NUMBER_VALID)) {
                return Integer.parseInt(result);
            }
            getWordLanguage(language, "errorCheckAccount");
            System.out.println();
        }
    }

    static String checkInputPassword(Locale language) {
        while (true) {
            String result = checkInputString(language);
            if (isValidPassword(result, language)) {
                return result;
            }
        }
    }

    static boolean isValidPassword(String password, Locale language) {
        int lengthPassword = password.length();
        if (lengthPassword < 8 || lengthPassword > 31) {
            getWordLanguage(language, "errorPasswordLength");
            System.out.println();
            return false;
        } else {
            int countDigit = 0;
            int countLetter = 0;
            for (int i = 0; i < lengthPassword; i++) {
                if (Character.isDigit(password.charAt(i))) {
                    countDigit++;
                } else if (Character.isLetter(password.charAt(i))) {
                    countLetter++;
                }
            }
            if (countDigit < 1 || countLetter < 1) {
                getWordLanguage(language, "errorPasswordAlphanumeric");
                System.out.println();
                return false;
            }
        }
        return true;
    }

    static boolean checkInputCaptcha(String captchaGenerated, Locale language) {
        System.out.println(captchaGenerated);
        getWordLanguage(language, "enterCaptcha");
        String captchaInput = checkInputString(language);
        for (int i = 0; i < captchaInput.length(); i++) {
            if (!captchaGenerated.contains(Character.toString(captchaInput.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    static String generateCaptchaText() {
        StringBuilder sb = new StringBuilder();
        final int LENGTH = 6;
        for (int i = 0; i < LENGTH; i++) {
            int index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }

    static void getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words = ResourceBundle.getBundle("", curLocate);
        String value = words.getString(key);
        System.out.printf(value);
    }

    static void login(Locale language, Account account) {
        getWordLanguage(language, "enterAccountNumber");
        int accountNumber = checkInputAccount(language);
        getWordLanguage(language, "enterPassword");
        String passString = checkInputPassword(language);
        String captchaGenerated = generateCaptchaText();
        while (true) {
            if (checkInputCaptcha(captchaGenerated, language)) {
                getWordLanguage(language, "loginSuccess");
                System.out.println();
                return;
            } else {
                getWordLanguage(language, "errorCaptcha");
                System.out.println();
            }
        }
    }
}
