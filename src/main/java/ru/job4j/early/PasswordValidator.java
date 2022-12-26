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
        if (!hasUpperCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!hasLowerCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!hasDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!hasSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (hasSubstrings(password)) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user"
            );
        }
        return password;
    }

    private static boolean hasUpperCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLowerCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDigit(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSymbol(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))
                    && !Character.isDigit(word.charAt(i))) {
                return true;
            }
        }
        return false;
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
