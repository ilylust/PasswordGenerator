import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {
        int length = 8; // default value
        System.out.println("Input password length: ");
        try {
            length = Integer.parseInt(System.console().readLine());
        } catch (NumberFormatException _) {
            System.out.println("Invalid length will default to " + length);
        }
        System.out.println(generatePassword(length));
    }

    public static String generatePassword(int length) {
        final String ALL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%^@&*()_+{}[]";

        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }

        return shufflePassword(password.toString());
    }

    public static String shufflePassword(String password) {
        SecureRandom random = new SecureRandom();
        char[] charArray = password.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int randomInt = random.nextInt(charArray.length);
            char temp = charArray[i];
            charArray[i] = charArray[randomInt];
            charArray[randomInt] = temp;
        }
        return new String(charArray);
    }
}