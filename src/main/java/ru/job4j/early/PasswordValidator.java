package ru.job4j.early;

public class PasswordValidator {

    private static final String[] SUBSTRINGS = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (hasSubstrings(password)) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user"
            );
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }
            if (Character.isLowerCase(ch)) {
                hasLower = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
            if (!Character.isDigit(ch) && !Character.isLetter(ch)) {
                hasSymbol = true;
            }
            if (hasDigit && hasLower && hasSymbol && hasUpper) {
                break;
            }
        }
        if (!hasLower) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!hasUpper) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!hasDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!hasSymbol) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        return password;
    }

    private static boolean hasSubstrings(String word) {
        for (String substring : SUBSTRINGS) {
            if (word.toLowerCase().contains(substring)) {
                return true;
            }
        }
        return false;
    }
}
