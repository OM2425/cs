import java.util.*;

public class Captcha {

    // Method to generate random CAPTCHA string
    public String generateCaptcha() {
        Random random = new Random();
        int length = 5;
        StringBuffer captchaStringBuffer = new StringBuffer();

        // Generate random CAPTCHA string of 5 characters
        for (int i = 0; i < length; i++) {
            int captchaNumber = Math.abs(random.nextInt()) % 62; // Generates a number between 0-61
            int charNumber = 0;

            // Character logic: A-Z (65-90), a-z (97-122), 0-9 (48-57)
            if (captchaNumber < 26) {
                charNumber = 65 + captchaNumber; // Uppercase letter
            } else if (captchaNumber < 52) {
                charNumber = 97 + (captchaNumber - 26); // Lowercase letter
            } else {
                charNumber = 48 + (captchaNumber - 52); // Digits
            }

            captchaStringBuffer.append((char) charNumber);
        }

        return captchaStringBuffer.toString();
    }

    // Main method to verify CAPTCHA input
    public static void main(String[] args) {
        Captcha captcha = new Captcha();
        String generatedCaptcha = captcha.generateCaptcha(); // Generate random CAPTCHA string
        System.out.println("Randomly Selected CAPTCHA string is: " + generatedCaptcha);

        // Use Scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter CAPTCHA String: ");
        String userInput = scanner.nextLine(); // Read user input

        // Compare the generated CAPTCHA with the user input
        if (generatedCaptcha.equals(userInput)) {
            System.out.println("Both strings are same.... CAPTCHA Verified!");
        } else {
            System.out.println("Both strings are not same.... CAPTCHA Failed!");
        }

        scanner.close();
    }
}

