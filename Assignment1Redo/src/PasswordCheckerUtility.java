import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provides utility methods for password checking and validation.
 * 
 * @author andrewchiaramonte
 */
public class PasswordCheckerUtility extends java.lang.Object {

	/**
	 * Constructs a new PasswordCheckerUtility object.
	 */
	PasswordCheckerUtility() {
		// Empty constructor
	}

	/**
	 * Compares two passwords for equality.
	 *
	 * @param password        The first password to compare.
	 * @param passwordConfirm The second password to compare for equality.
	 * @throws UnmatchedException If the passwords do not match.
	 */
	static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException("Passwords do not match");
		}
	}

	/**
	 * Compares two passwords for equality and returns a boolean indicating whether
	 * they match.
	 *
	 * @param password        The first password to compare.
	 * @param passwordConfirm The second password to compare for equality.
	 * @return boolean true if the passwords match, false otherwise.
	 */
	static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		// Implement password comparison logic and return true or false
		// based on whether the passwords match
		return password.equals(passwordConfirm);
	}

	/**
	 * Gets a list of invalid passwords from a given list.
	 *
	 * @param passwords A list of passwords to check for validity.
	 * @return ArrayList<String> of invalid passwords along with their error
	 *         messages.
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<>();
		// Iterate through the list of passwords and check for invalid ones
		for (String password : passwords) {
			try {
				isValidPassword(password);
			} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
					| NoSpecialCharacterException | InvalidSequenceException e) {
				invalidPasswords.add(password + " " + e.getMessage());
			}
		}
		return invalidPasswords;
	}

	/**
	 * Checks if the password contains between 6 and 9 characters.
	 *
	 * @param password The password to check.
	 * @return boolean true if the password has between 6 and 9 characters, false
	 *         otherwise.
	 */
	static boolean hasBetweenSixAndNineChars(String password) {
		int length = password.length();
		return length >= 6 && length <= 9;
	}

	/**
	 * Checks if the password contains at least one numeric character.
	 *
	 * @param password The password to check.
	 * @return boolean true if the password contains at least one digit, false
	 *         otherwise.
	 * @throws NoDigitException If the password does not contain any digit.
	 */
	static boolean hasDigit(String password) throws NoDigitException {
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(password);
		if (!matcher.find()) {
			throw new NoDigitException("The password must contain at least one digit");
		} else
			return true;
	}

	/**
	 * Checks if the password contains at least one lowercase alpha character.
	 *
	 * @param password The password to check.
	 * @return boolean true if the password contains at least one lowercase
	 *         alphabetic character, false otherwise.
	 * @throws NoLowerAlphaException If the password does not contain any lowercase
	 *                               alphabetic character.
	 */
	static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		Pattern pattern = Pattern.compile("[a-z]");
		Matcher matcher = pattern.matcher(password);
		if (!matcher.find()) {
			throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
		} else
			return true;
	}

	/**
	 * Checks if the password contains a special character.
	 *
	 * @param password The password to check.
	 * @return boolean true if the password contains at least one special character,
	 *         false otherwise.
	 * @throws NoSpecialCharacterException If the password does not contain any
	 *                                     special character.
	 */
	static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]");
		Matcher matcher = pattern.matcher(password);
		if (!matcher.find()) {
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		} else
			return true;
	}

	/**
	 * Checks if the password contains an uppercase alpha character.
	 *
	 * @param password The password to check.
	 * @return boolean true if the password contains at least one uppercase
	 *         alphabetic character, false otherwise.
	 * @throws NoUpperAlphaException If the password does not contain any uppercase
	 *                               alphabetic character.
	 */
	static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(password);
		if (!matcher.find()) {
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
		} else
			return true;
	}

	/**
	 * Checks if the password length is at least 6 characters.
	 *
	 * @param password The password to check.
	 * @return boolean true if the password length is at least 6 characters, false
	 *         otherwise.
	 * @throws LengthException If the password length is less than 6 characters.
	 */
	static boolean isValidLength(String password) throws LengthException {
		if (password.length() >= 6) {
			return true;
		} else {
			throw new LengthException("The password must be at least 6 characters long");
		}
	}

	/**
	 * Checks if the password is valid according to all rules.
	 *
	 * @param password The password to validate.
	 * @return boolean true if the password is valid, false otherwise.
	 * @throws LengthException             If the password length is less than 6
	 *                                     characters.
	 * @throws NoUpperAlphaException       If the password does not contain any
	 *                                     uppercase alphabetic character.
	 * @throws NoLowerAlphaException       If the password does not contain any
	 *                                     lowercase alphabetic character.
	 * @throws NoDigitException            If the password does not contain any
	 *                                     digit.
	 * @throws NoSpecialCharacterException If the password does not contain any
	 *                                     special character.
	 * @throws InvalidSequenceException    If the password contains more than 2 of
	 *                                     the same character in sequence.
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		boolean valid = true;

		if (!isValidLength(password)) {
			valid = false;
			throw new LengthException();
		}

		if (!hasUpperAlpha(password)) {
			valid = false;
			throw new NoUpperAlphaException();
		}

		if (!hasLowerAlpha(password)) {
			valid = false;
			throw new NoLowerAlphaException();
		}

		if (!hasDigit(password)) {
			valid = false;
			throw new NoDigitException();
		}

		if (!hasSpecialChar(password)) {
			valid = false;
			throw new NoSpecialCharacterException();
		}

		if (!NoSameCharInSequence(password)) {
			valid = false;
			throw new InvalidSequenceException();
		}

		return valid;
	}

	/**
	 * Checks if the password is weak (valid but 6-9 characters).
	 *
	 * @param password The password to check for weakness.
	 * @return boolean true if the password is valid but weak (6-9 characters),
	 *         false otherwise.
	 * @throws WeakPasswordException If the password is weak, indicating fewer than
	 *                               10 characters.
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		boolean result = false;
		try {
			if (isValidPassword(password) && hasBetweenSixAndNineChars(password)) {
				result = true;
				throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters");
			}
		} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
				| NoSpecialCharacterException | InvalidSequenceException e) {
			return false;
		}
		return result;
	}

	/**
	 * Checks if the password contains more than 2 of the same character in
	 * sequence.
	 *
	 * @param password The password to check for repeated characters in sequence.
	 * @return boolean true if the password does not contain more than two of the
	 *         same character in sequence, false otherwise.
	 * @throws InvalidSequenceException If the password contains more than two of
	 *                                  the same character in sequence.
	 */
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
