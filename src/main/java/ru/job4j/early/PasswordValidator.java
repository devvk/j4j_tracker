package ru.job4j.early;

public class PasswordValidator {

    private static final String[] NOT_ALLOWED_PASSWORDS = new String[]
            {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!containUpperCaseLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one "
                    + "uppercase letter");
        }
        if (!containLowerCaseLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one "
                    + "lowercase letter");
        }
        if (!containDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!containSpecialSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one "
                    + "special symbol");
        }
        if (containSubstrings(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: "
                    + "qwerty, 12345, password, admin, user");
        }
        return password;
    }

    private static boolean containSubstrings(String s) {
        for (String str : NOT_ALLOWED_PASSWORDS) {
            if (s.toLowerCase().contains(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containSubstrings("Ln2$mrQWerTY12"));
    }

    private static boolean containSpecialSymbol(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containLowerCaseLetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containUpperCaseLetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
