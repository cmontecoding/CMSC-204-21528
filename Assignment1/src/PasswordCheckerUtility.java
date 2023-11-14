import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility extends java.lang.Object {

    PasswordCheckerUtility() {
        // Empty constructor
    }

    // Compare equality of two passwords (void method)
    static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (!password.equals(passwordConfirm)) {
            throw new UnmatchedException("Passwords do not match");
        }
    }

    // Compare equality of two passwords (returns a boolean)
    static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        // Implement password comparison logic and return true or false
        // based on whether the passwords match
        return password.equals(passwordConfirm);
    }

    // Get status of invalid passwords from a list
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
        ArrayList<String> invalidPasswords = new ArrayList<>();
        // Iterate through the list of passwords and check for invalid ones
        for (String password : passwords) {
            try {
                if (!isValidPassword(password)) {
                    invalidPasswords.add(password);
                }
            } catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
                    | NoSpecialCharacterException | InvalidSequenceException e) {
                invalidPasswords.add(password);
            }
        }
        return invalidPasswords;
    }

    // Check if the password contains 6 to 9 characters
    static boolean hasBetweenSixAndNineChars(String password) {
        int length = password.length();
        return length >= 6 && length <= 9;
    }

    // Check if the password contains a numeric character
    static boolean hasDigit(String password) throws NoDigitException {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()) {
            throw new NoDigitException("The password must contain at least one digit");
        } else
            return true;
    }

    // Check if the password contains at least one lowercase alpha character
    static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()) {
            throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
        } else
            return true;
    }

    // Check if the password contains a special character
    static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        Pattern pattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()) {
            throw new NoSpecialCharacterException("The password must contain at least one special character");
        } else
            return true;
    }

    // Check if the password contains an uppercase alpha character
    static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()) {
            throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
        } else
            return true;
    }

    // Check if the password length is at least 6 characters
    static boolean isValidLength(String password) throws LengthException {
        if (password.length() >= 6) {
            return true;
        } else {
            throw new LengthException("The password must be at least 6 characters long");
        }
    }

    // Check if the password is valid according to all rules
    public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
            NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        if( isValidLength(password) &&
                hasUpperAlpha(password) &&
                hasLowerAlpha(password) &&
                hasDigit(password) &&
                hasSpecialChar(password) &&
                NoSameCharInSequence(password)) {
            return true;
                } else {
            return false;
                }
    }

    // Check if the password is weak (valid but 6-9 characters)
    public static boolean isWeakPassword(String password) throws WeakPasswordException {
        try {
            if (isValidPassword(password) && hasBetweenSixAndNineChars(password)) {
                throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters");
            } else {
                return true;
            }
        } catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
                | NoSpecialCharacterException | InvalidSequenceException e) {
            return false;
        }
    }

    // Check if the password contains more than 2 of the same character in sequence
    static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
        int length = password.length();
        for (int i = 0; i < length && i + 3 <= length; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2)) {
                throw new InvalidSequenceException(
                        "The password cannot contain more than two of the same character in sequence");
            }
        }
        return true;
    }
}
