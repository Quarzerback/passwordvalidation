package org.example;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class passwordvalidation {
    public static void main(String[] args) {
        String generatedPassword = generateSecurePassword();
        System.out.println("New password: " + generatedPassword);
    }
    public static boolean checkLength(String password) {
    return password.length() > 7;

    }

    public static boolean checkForDigits(String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean checkForUpperAndLowerCase(String password) {
        return password.matches(".*[A-Z].*") && password.matches(".*[a-z].*");
    }

    public static boolean checkForCommonlyUsed(String password) {
        return password.matches(".*[Pp]assword\\d.*") || password.matches(".*[Aa]\\d{7}.*");
    }

    public static String generateSecurePassword() {
        int minLength = 12;
        int maxLength = 15;

        int passwordLength = minLength + new SecureRandom().nextInt(maxLength - minLength + 1);

        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String digitChars = "0123456789";
        String specialChars = "!@#$%^&*()-=_+";

        SecureRandom random = new SecureRandom();

        List<Character> characters = new ArrayList<>();
        characters.add(uppercaseChars.charAt(random.nextInt(uppercaseChars.length())));
        characters.add(lowercaseChars.charAt(random.nextInt(lowercaseChars.length())));
        characters.add(digitChars.charAt(random.nextInt(digitChars.length())));

        Collections.shuffle(characters);

        StringBuilder passwordBuilder = new StringBuilder();
        for (char character : characters) {
            passwordBuilder.append(character);
        }

        for (int i = 3; i < passwordLength; i++) {
            String validChars = uppercaseChars + lowercaseChars + digitChars + specialChars;
            passwordBuilder.append(validChars.charAt(random.nextInt(validChars.length())));
        }

        String password = passwordBuilder.toString();


        return password;
    }

}