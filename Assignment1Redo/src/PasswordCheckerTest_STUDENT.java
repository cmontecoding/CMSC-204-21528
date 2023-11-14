
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @author Andrew Chiaramonte
 *
 */
public class PasswordCheckerTest_STUDENT {

	@Before
	public void setUp() throws Exception {
		ArrayList<String> validPasswords = new ArrayList<String>();
		validPasswords.add("abcdeA!1");
	}

	@After
	public void tearDown() throws Exception {
		ArrayList<String> validPasswords = null;
	}

	/**
	 * Test if the password is less than 6 characters long. This test should throw a
	 * LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try {
			PasswordCheckerUtility.isValidLength("abcde");
		} catch (LengthException e) {
			assertTrue("Successfully threw a LengthException", true);
		} catch (Exception e) {
			fail("Threw some other exception besides LengthException");
		}
		try {
			PasswordCheckerUtility.isValidLength("abcdef");
		} catch (LengthException e) {
			fail("Threw LengthException when it should not have");
		} catch (Exception e) {
			fail("Threw some other exception besides LengthException");
		}
	}

	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try {
			PasswordCheckerUtility.hasUpperAlpha("abcde");
		} catch (NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaException", true);
		} catch (Exception e) {
			fail("Threw some other exception besides NoUpperAlphaException");
		}
		try {
			PasswordCheckerUtility.hasUpperAlpha("abcdeA");
		} catch (NoUpperAlphaException e) {
			fail("Threw NoUpperAlphaException when it should not have");
		} catch (Exception e) {
			fail("Threw some other exception besides NoUpperAlphaException");
		}
	}

	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try {
			PasswordCheckerUtility.hasLowerAlpha("ABCDE");
		} catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaException", true);
		} catch (Exception e) {
			fail("Threw some other exception besides NoLowerAlphaException");
		}
		try {
			PasswordCheckerUtility.hasLowerAlpha("ABCDEa");
		} catch (NoLowerAlphaException e) {
			fail("Threw NoLowerAlphaException when it should not have");
		} catch (Exception e) {
			fail("Threw some other exception besides NoLowerAlphaException");
		}
	}

	/**
	 * Test if the password is valid but 6-9 characters This test should throw a
	 * WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		try {
			PasswordCheckerUtility.isWeakPassword("abcde1!B");
		} catch (WeakPasswordException e) {
			assertTrue("Successfully threw a WeakPasswordException", true);
		} catch (Exception e) {
			fail("Threw some other exception besides WeakPasswordException");
		}
		try {
			PasswordCheckerUtility.isWeakPassword("abcde1!Bcz");
		} catch (WeakPasswordException e) {
			fail("Threw WeakPasswordException when it should not have");
		} catch (Exception e) {
			fail("Threw some other exception besides WeakPasswordException");
		}
		try {
			PasswordCheckerUtility.isWeakPassword("12");
		} catch (WeakPasswordException e) {
			fail("Threw WeakPasswordException when it should not have");
		} catch (Exception e) {
			fail("Threw some other exception besides WeakPasswordException");
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			PasswordCheckerUtility.NoSameCharInSequence("abcccde");
		} catch (InvalidSequenceException e) {
			assertTrue("Successfully threw a InvalidSequenceException", true);
		} catch (Exception e) {
			fail("Threw some other exception besides InvalidSequenceException");
		}
		try {
			PasswordCheckerUtility.NoSameCharInSequence("abccde");
		} catch (InvalidSequenceException e) {
			fail("Threw InvalidSequenceException when it should not have");
		} catch (Exception e) {
			fail("Threw some other exception besides InvalidSequenceException");
		}
		try {
			PasswordCheckerUtility.NoSameCharInSequence("abccdeAAA");
		} catch (InvalidSequenceException e) {
			assertTrue("Successfully threw a InvalidSequenceException", true);
		} catch (Exception e) {
			fail("Threw some other exception besides InvalidSequenceException");
		}
	}

	/**
	 * Test if the password has at least one digit One test should throw a
	 * NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		try {
			PasswordCheckerUtility.hasDigit("abcde");
		} catch (NoDigitException e) {
			assertTrue("Successfully threw a NoDigitException", true);
		} catch (Exception e) {
			fail("Threw some other exception besides NoDigitException");
		}
		try {
			PasswordCheckerUtility.hasDigit("abcde1");
		} catch (NoDigitException e) {
			fail("Threw NoDigitException when it should not have");
		} catch (Exception e) {
			fail("Threw some other exception besides NoDigitException");
		}
	}

	/**
	 * Test correct passwords One test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			PasswordCheckerUtility.isValidPassword("abcde1A!");
		} catch (Exception e) {
			fail("Threw some exception when it should not have");
		}
		try {
			PasswordCheckerUtility.isValidPassword("abcde1A");
		} catch (Exception e) {
			assertTrue("Threw some other exception when it should have", true);
		}
	}

	/**
	 * Test the invalidPasswords method Check the results of the ArrayList of
	 * Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		try {
			ArrayList<String> results;
			ArrayList<String> passwords;
			passwords = new ArrayList<String>();
			passwords.add("abcde1A!");
			passwords.add("abcde1A");
			passwords.add("abcde1A!!");
			passwords.add("abced!f");
			passwords.add("AAAAA1A!");
			results = PasswordCheckerUtility.getInvalidPasswords(passwords);
			assertEquals(results.size(), 3);
		} catch (Exception e) {
			fail("Threw some exception when it should not have");
		}
	}

	/**
	 * Test the comparePasswords() method One test should not throw an exception
	 */
	@Test
	public void testComparePasswords() {
		try {
			PasswordCheckerUtility.comparePasswords("abcde1A!", "abcde1A!");
		} catch (UnmatchedException e) {
			fail("Threw unmatched exception when it should not have");
		} catch (Exception e) {
			fail("Threw some exception when it should not have");
		}
		try {
			PasswordCheckerUtility.comparePasswords("abcde1A!", "abcde1A");
		} catch (UnmatchedException e) {
			assertTrue("Threw unmatched other exception when it should have", true);
		} catch (Exception e) {
			fail("Threw some exception when it should not have");
		}
	}

	/**
	 * Test the comparePasswordsWithReturn() method One test should not return true
	 */
	@Test
	public void testComparePasswordsWithReturn() {
		try {
			boolean results;
			results = PasswordCheckerUtility.comparePasswordsWithReturn("abcde1A!", "abcde1A!");
			assertTrue(results);
		} catch (Exception e) {
			fail("Threw some exception when it should not have");
		}
		try {
			boolean results;
			results = PasswordCheckerUtility.comparePasswordsWithReturn("abcde1A!", "abcde1A");
			assertFalse(results);
		} catch (Exception e) {
			fail("Threw some exception when it should not have");
		}
	}

	/**
	 * Test the hasBetweenSixAndNineChars() method At least one test should not
	 * return true
	 */
	@Test
	public void testHasBetweenSixAndNineChars() {
		try {
			boolean results;
			results = PasswordCheckerUtility.hasBetweenSixAndNineChars("abcde1A!");
			assertTrue(results);
		} catch (Exception e) {
			fail("Threw some exception when it should not have");
		}
		try {
			boolean results;
			results = PasswordCheckerUtility.hasBetweenSixAndNineChars("abcde1AB!!");
			assertFalse(results);
		} catch (Exception e) {
			fail("Threw some exception when it should not have");
		}
		try {
			boolean results;
			results = PasswordCheckerUtility.hasBetweenSixAndNineChars("abcde");
			assertFalse(results);
		} catch (Exception e) {
			fail("Threw some exception when it should not have");
		}
	}

	/**
	 * Test the hasSpecialChar() method At least one test should throw an exception
	 */
	@Test
	public void testHasSpecialChar() {
		try {
			PasswordCheckerUtility.hasSpecialChar("abcde1A!");
		} catch (NoSpecialCharacterException e) {
			fail("Threw nospecialcharacter exception when it should not have");
		} catch (Exception e) {
			fail("Threw some exception when it should not have");
		}
		try {
			PasswordCheckerUtility.hasSpecialChar("abcde1A");
		} catch (NoSpecialCharacterException e) {
			assertTrue("Threw nospecialcharacter exception when it should have", true);
		} catch (Exception e) {
			fail("Threw some exception when it should not have");
		}
		try {
			PasswordCheckerUtility.hasSpecialChar("abcde1A!!");
		} catch (NoSpecialCharacterException e) {
			fail("Threw nospecialcharacter exception when it should not have");
		} catch (Exception e) {
			fail("Threw some exception when it should not have");
		}
	}
}
